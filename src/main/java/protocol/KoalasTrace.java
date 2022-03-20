/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package protocol;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KoalasTrace implements org.apache.thrift.TBase<KoalasTrace, KoalasTrace._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("KoalasTrace");

  private static final org.apache.thrift.protocol.TField ROOT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("rootId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PARENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("parentId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CHILD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("childId", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new KoalasTraceStandardSchemeFactory());
    schemes.put(TupleScheme.class, new KoalasTraceTupleSchemeFactory());
  }

  public String rootId; // required
  public String parentId; // required
  public String childId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROOT_ID((short)1, "rootId"),
    PARENT_ID((short)2, "parentId"),
    CHILD_ID((short)3, "childId");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ROOT_ID
          return ROOT_ID;
        case 2: // PARENT_ID
          return PARENT_ID;
        case 3: // CHILD_ID
          return CHILD_ID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROOT_ID, new org.apache.thrift.meta_data.FieldMetaData("rootId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARENT_ID, new org.apache.thrift.meta_data.FieldMetaData("parentId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHILD_ID, new org.apache.thrift.meta_data.FieldMetaData("childId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(KoalasTrace.class, metaDataMap);
  }

  public KoalasTrace() {
  }

  public KoalasTrace(
    String rootId,
    String parentId,
    String childId)
  {
    this();
    this.rootId = rootId;
    this.parentId = parentId;
    this.childId = childId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public KoalasTrace(KoalasTrace other) {
    if (other.isSetRootId()) {
      this.rootId = other.rootId;
    }
    if (other.isSetParentId()) {
      this.parentId = other.parentId;
    }
    if (other.isSetChildId()) {
      this.childId = other.childId;
    }
  }

  public KoalasTrace deepCopy() {
    return new KoalasTrace(this);
  }

  @Override
  public void clear() {
    this.rootId = null;
    this.parentId = null;
    this.childId = null;
  }

  public String getRootId() {
    return this.rootId;
  }

  public KoalasTrace setRootId(String rootId) {
    this.rootId = rootId;
    return this;
  }

  public void unsetRootId() {
    this.rootId = null;
  }

  /** Returns true if field rootId is set (has been assigned a value) and false otherwise */
  public boolean isSetRootId() {
    return this.rootId != null;
  }

  public void setRootIdIsSet(boolean value) {
    if (!value) {
      this.rootId = null;
    }
  }

  public String getParentId() {
    return this.parentId;
  }

  public KoalasTrace setParentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

  public void unsetParentId() {
    this.parentId = null;
  }

  /** Returns true if field parentId is set (has been assigned a value) and false otherwise */
  public boolean isSetParentId() {
    return this.parentId != null;
  }

  public void setParentIdIsSet(boolean value) {
    if (!value) {
      this.parentId = null;
    }
  }

  public String getChildId() {
    return this.childId;
  }

  public KoalasTrace setChildId(String childId) {
    this.childId = childId;
    return this;
  }

  public void unsetChildId() {
    this.childId = null;
  }

  /** Returns true if field childId is set (has been assigned a value) and false otherwise */
  public boolean isSetChildId() {
    return this.childId != null;
  }

  public void setChildIdIsSet(boolean value) {
    if (!value) {
      this.childId = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ROOT_ID:
      if (value == null) {
        unsetRootId();
      } else {
        setRootId((String)value);
      }
      break;

    case PARENT_ID:
      if (value == null) {
        unsetParentId();
      } else {
        setParentId((String)value);
      }
      break;

    case CHILD_ID:
      if (value == null) {
        unsetChildId();
      } else {
        setChildId((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ROOT_ID:
      return getRootId();

    case PARENT_ID:
      return getParentId();

    case CHILD_ID:
      return getChildId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ROOT_ID:
      return isSetRootId();
    case PARENT_ID:
      return isSetParentId();
    case CHILD_ID:
      return isSetChildId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof KoalasTrace)
      return this.equals((KoalasTrace)that);
    return false;
  }

  public boolean equals(KoalasTrace that) {
    if (that == null)
      return false;

    boolean this_present_rootId = true && this.isSetRootId();
    boolean that_present_rootId = true && that.isSetRootId();
    if (this_present_rootId || that_present_rootId) {
      if (!(this_present_rootId && that_present_rootId))
        return false;
      if (!this.rootId.equals(that.rootId))
        return false;
    }

    boolean this_present_parentId = true && this.isSetParentId();
    boolean that_present_parentId = true && that.isSetParentId();
    if (this_present_parentId || that_present_parentId) {
      if (!(this_present_parentId && that_present_parentId))
        return false;
      if (!this.parentId.equals(that.parentId))
        return false;
    }

    boolean this_present_childId = true && this.isSetChildId();
    boolean that_present_childId = true && that.isSetChildId();
    if (this_present_childId || that_present_childId) {
      if (!(this_present_childId && that_present_childId))
        return false;
      if (!this.childId.equals(that.childId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(KoalasTrace other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    KoalasTrace typedOther = (KoalasTrace)other;

    lastComparison = Boolean.valueOf(isSetRootId()).compareTo(typedOther.isSetRootId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRootId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rootId, typedOther.rootId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParentId()).compareTo(typedOther.isSetParentId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParentId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parentId, typedOther.parentId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChildId()).compareTo(typedOther.isSetChildId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChildId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.childId, typedOther.childId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("KoalasTrace(");
    boolean first = true;

    sb.append("rootId:");
    if (this.rootId == null) {
      sb.append("null");
    } else {
      sb.append(this.rootId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("parentId:");
    if (this.parentId == null) {
      sb.append("null");
    } else {
      sb.append(this.parentId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("childId:");
    if (this.childId == null) {
      sb.append("null");
    } else {
      sb.append(this.childId);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class KoalasTraceStandardSchemeFactory implements SchemeFactory {
    public KoalasTraceStandardScheme getScheme() {
      return new KoalasTraceStandardScheme();
    }
  }

  private static class KoalasTraceStandardScheme extends StandardScheme<KoalasTrace> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, KoalasTrace struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ROOT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.rootId = iprot.readString();
              struct.setRootIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.parentId = iprot.readString();
              struct.setParentIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHILD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.childId = iprot.readString();
              struct.setChildIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, KoalasTrace struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.rootId != null) {
        oprot.writeFieldBegin(ROOT_ID_FIELD_DESC);
        oprot.writeString(struct.rootId);
        oprot.writeFieldEnd();
      }
      if (struct.parentId != null) {
        oprot.writeFieldBegin(PARENT_ID_FIELD_DESC);
        oprot.writeString(struct.parentId);
        oprot.writeFieldEnd();
      }
      if (struct.childId != null) {
        oprot.writeFieldBegin(CHILD_ID_FIELD_DESC);
        oprot.writeString(struct.childId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KoalasTraceTupleSchemeFactory implements SchemeFactory {
    public KoalasTraceTupleScheme getScheme() {
      return new KoalasTraceTupleScheme();
    }
  }

  private static class KoalasTraceTupleScheme extends TupleScheme<KoalasTrace> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, KoalasTrace struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRootId()) {
        optionals.set(0);
      }
      if (struct.isSetParentId()) {
        optionals.set(1);
      }
      if (struct.isSetChildId()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetRootId()) {
        oprot.writeString(struct.rootId);
      }
      if (struct.isSetParentId()) {
        oprot.writeString(struct.parentId);
      }
      if (struct.isSetChildId()) {
        oprot.writeString(struct.childId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, KoalasTrace struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.rootId = iprot.readString();
        struct.setRootIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.parentId = iprot.readString();
        struct.setParentIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.childId = iprot.readString();
        struct.setChildIdIsSet(true);
      }
    }
  }

}

