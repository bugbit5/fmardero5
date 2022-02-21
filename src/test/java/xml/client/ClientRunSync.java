package xml.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import thrift.xml.client.impl.TestServiceSync;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:xml/client/koalas-client.xml"})
public class ClientRunSync {

    @Autowired
    TestServiceSync testServiceSync;

    @Test
    public void testRunSync(){
        long a = System.currentTimeMillis ();
        for (int i = 0; i < 500; i++) {
            try {
                testServiceSync.getRemoteRpc ();
                testServiceSync.koaloasTest1 ();
                testServiceSync.koaloasTest2 ();
                testServiceSync.koaloasTest3 ();
                testServiceSync.koaloasTest4 ();
                testServiceSync.koaloasTest5 ();
                testServiceSync.koaloasTest6 ();
            }catch (Exception e){
                e.printStackTrace ();
            }

        }
        System.out.println (System.currentTimeMillis ()-a);
    }
}
