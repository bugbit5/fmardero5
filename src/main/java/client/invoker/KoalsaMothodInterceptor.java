package client.invoker;

import client.async.ReleaseResourcesKoalasAsyncCallBack;
import client.cluster.Icluster;
import client.cluster.ServerObject;
import client.proxyfactory.KoalasClientProxy;
import ex.RSAException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClient;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * Copyright (C) 2018
 * All rights reserved
 * User: yulong.zhang
 * Date:2018年11月23日11:13:33
 */
public class KoalsaMothodInterceptor implements MethodInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger ( KoalsaMothodInterceptor.class );

    private Icluster icluster;
    private int retryTimes;
    private boolean retryRequest;
    private KoalasClientProxy koalasClientProxy;
    private int asyncTimeOut;

    public KoalsaMothodInterceptor(Icluster icluster, int retryTimes, boolean retryRequest, KoalasClientProxy koalasClientProxy, int asyncTimeOut) {
        this.icluster = icluster;
        this.retryTimes = retryTimes;
        this.retryRequest = retryRequest;
        this.koalasClientProxy = koalasClientProxy;
        this.asyncTimeOut = asyncTimeOut;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws InvocationTargetException, IllegalAccessException {

        Method method = invocation.getMethod ();
        String methodName = method.getName ();
        Object[] args = invocation.getArguments ();

        Class<?>[] parameterTypes = method.getParameterTypes ();
        if (method.getDeclaringClass () == Object.class) {
            try {
                return method.invoke ( this, args );
            } catch (IllegalAccessException e) {
                LOG.error ( e.getMessage (), e );
            }
        }
        if ("toString".equals ( methodName ) && parameterTypes.length == 0) {
            return this.toString ();
        }
        if ("hashCode".equals ( methodName ) && parameterTypes.length == 0) {
            return this.hashCode ();
        }
        if ("equals".equals ( methodName ) && parameterTypes.length == 1) {
            return this.equals ( args[0] );
        }

        TTransport socket = null;
        int currTryTimes = 0;
        while (currTryTimes++ < retryTimes) {
            ServerObject serverObject = icluster.getObjectForRemote ();
            if (serverObject == null) return null;
            GenericObjectPool<TTransport> genericObjectPool = serverObject.getGenericObjectPool ();
            try {
                long before = System.currentTimeMillis ();
                socket = genericObjectPool.borrowObject ();
                long after = System.currentTimeMillis ();
                LOG.debug ( "get Object from pool with {} ms", after - before );
            } catch (Exception e) {
                if (socket != null)
                    genericObjectPool.returnObject ( socket );
                LOG.error ( e.getMessage (), e );
                return null;
            }

            Object obj = koalasClientProxy.getInterfaceClientInstance ( socket, serverObject.getRemoteServer ().getServer () );

            if (obj instanceof TAsyncClient) {
                ((TAsyncClient) obj).setTimeout ( asyncTimeOut );
                if (args.length < 1) {
                    genericObjectPool.returnObject ( socket );
                    throw new IllegalStateException ( "args number error" );
                }

                Object argslast = args[args.length - 1];
                if (!(argslast instanceof AsyncMethodCallback)) {
                    genericObjectPool.returnObject ( socket );
                    throw new IllegalStateException ( "args type error" );
                }

                AsyncMethodCallback callback = (AsyncMethodCallback) argslast;
                ReleaseResourcesKoalasAsyncCallBack releaseResourcesKoalasAsyncCallBack = new ReleaseResourcesKoalasAsyncCallBack ( callback, serverObject, socket );
                args[args.length - 1] = releaseResourcesKoalasAsyncCallBack;

            }
            try {
                Object o = method.invoke ( obj, args );
                if (socket instanceof TSocket) {
                    genericObjectPool.returnObject ( socket );
                }
                return o;
            } catch (Exception e) {
                Throwable cause = (e.getCause () == null) ? e : e.getCause ();

                boolean ifreturn = false;
                if (cause instanceof TApplicationException) {
                    if (((TApplicationException) cause).getType () == 6666) {
                        LOG.info ( "the server{}--serverName【{}】 thread pool is busy ,retry it!", serverObject.getRemoteServer (),koalasClientProxy.getServiceInterface ().getName () );
                        if (socket != null) {
                            genericObjectPool.returnObject ( socket );
                            ifreturn = true;
                        }
                        Thread.yield ();
                        if (retryRequest)
                            continue;
                    }

                    if (((TApplicationException) cause).getType () == 9999) {
                        LOG.error ( "rsa error with service--{}--serverName【{}】", serverObject.getRemoteServer (),koalasClientProxy.getServiceInterface ().getName () );
                        if (socket != null) {
                            genericObjectPool.returnObject ( socket );
                        }
                        return null;
                    }

                    if (((TApplicationException) cause).getType () == 6699) {
                        LOG.error ( "this client is not rsa support,please get the privateKey and publickey with server--{}--serverName【{}】", serverObject.getRemoteServer (),koalasClientProxy.getServiceInterface ().getName () );
                        if (socket != null) {
                            genericObjectPool.returnObject ( socket );
                        }
                        return null;
                    }
                }

                if (cause instanceof RSAException) {
                    LOG.error ( "this client privateKey or publicKey is error,please check it! --{}--serverName【{}】", serverObject.getRemoteServer (),koalasClientProxy.getServiceInterface ().getName () );
                    if (socket != null) {
                        genericObjectPool.returnObject ( socket );
                    }
                    return null;
                }

                if (cause.getCause () != null && cause.getCause () instanceof ConnectException) {
                    LOG.info ( "the server {}--serverName【{}】 maybe is shutdown ,retry it!", serverObject.getRemoteServer (),koalasClientProxy.getServiceInterface ().getName () );
                    try {
                        if (socket != null) {
                            genericObjectPool.returnObject ( socket );
                            ifreturn = true;
                        }

                        if (retryRequest)
                            continue;
                    } catch (Exception e1) {
                        LOG.error ( "invalidateObject error!", e1 );
                    }
                }

                if (cause.getCause () != null && cause.getCause () instanceof SocketTimeoutException) {
                    LOG.info ( "read timeout SocketTimeoutException,retry it! {}--serverName【{}】", serverObject.getRemoteServer (),koalasClientProxy.getServiceInterface ().getName () );
                    if (socket != null) {
                        try {
                            genericObjectPool.invalidateObject ( socket );
                            ifreturn = true;
                        } catch (Exception e1) {
                            LOG.error ( "invalidateObject error ,", e );
                            return null;
                        }
                    }
                    if (retryRequest)
                        continue;
                }
                if (socket != null && !ifreturn)
                    genericObjectPool.returnObject ( socket );
                LOG.error ( "invoke server error,server ip -【{}】,port -【{}】--serverName【{}】", serverObject.getRemoteServer ().getIp (), serverObject.getRemoteServer ().getPort () );
                throw e;
            }
        }
        return null;
    }

}
