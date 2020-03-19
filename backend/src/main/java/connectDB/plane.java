/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package connectDB;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-03-18")
public class plane implements org.apache.thrift.TBase<plane, plane._Fields>, java.io.Serializable, Cloneable, Comparable<plane> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("plane");

  private static final org.apache.thrift.protocol.TField ID_PLANE_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_plane", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PLANENAME_FIELD_DESC = new org.apache.thrift.protocol.TField("planename", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ID_SALE_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_sale", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new planeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new planeTupleSchemeFactory();

  public int Id_plane; // required
  public @org.apache.thrift.annotation.Nullable String planename; // required
  public int Id_sale; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID_PLANE((short)1, "Id_plane"),
    PLANENAME((short)2, "planename"),
    ID_SALE((short)3, "Id_sale");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID_PLANE
          return ID_PLANE;
        case 2: // PLANENAME
          return PLANENAME;
        case 3: // ID_SALE
          return ID_SALE;
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
    @org.apache.thrift.annotation.Nullable
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
  private static final int __ID_PLANE_ISSET_ID = 0;
  private static final int __ID_SALE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID_PLANE, new org.apache.thrift.meta_data.FieldMetaData("Id_plane", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PLANENAME, new org.apache.thrift.meta_data.FieldMetaData("planename", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_SALE, new org.apache.thrift.meta_data.FieldMetaData("Id_sale", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(plane.class, metaDataMap);
  }

  public plane() {
  }

  public plane(
    int Id_plane,
    String planename,
    int Id_sale)
  {
    this();
    this.Id_plane = Id_plane;
    setId_planeIsSet(true);
    this.planename = planename;
    this.Id_sale = Id_sale;
    setId_saleIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public plane(plane other) {
    __isset_bitfield = other.__isset_bitfield;
    this.Id_plane = other.Id_plane;
    if (other.isSetPlanename()) {
      this.planename = other.planename;
    }
    this.Id_sale = other.Id_sale;
  }

  public plane deepCopy() {
    return new plane(this);
  }

  @Override
  public void clear() {
    setId_planeIsSet(false);
    this.Id_plane = 0;
    this.planename = null;
    setId_saleIsSet(false);
    this.Id_sale = 0;
  }

  public int getId_plane() {
    return this.Id_plane;
  }

  public plane setId_plane(int Id_plane) {
    this.Id_plane = Id_plane;
    setId_planeIsSet(true);
    return this;
  }

  public void unsetId_plane() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_PLANE_ISSET_ID);
  }

  /** Returns true if field Id_plane is set (has been assigned a value) and false otherwise */
  public boolean isSetId_plane() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_PLANE_ISSET_ID);
  }

  public void setId_planeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_PLANE_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public String getPlanename() {
    return this.planename;
  }

  public plane setPlanename(@org.apache.thrift.annotation.Nullable String planename) {
    this.planename = planename;
    return this;
  }

  public void unsetPlanename() {
    this.planename = null;
  }

  /** Returns true if field planename is set (has been assigned a value) and false otherwise */
  public boolean isSetPlanename() {
    return this.planename != null;
  }

  public void setPlanenameIsSet(boolean value) {
    if (!value) {
      this.planename = null;
    }
  }

  public int getId_sale() {
    return this.Id_sale;
  }

  public plane setId_sale(int Id_sale) {
    this.Id_sale = Id_sale;
    setId_saleIsSet(true);
    return this;
  }

  public void unsetId_sale() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_SALE_ISSET_ID);
  }

  /** Returns true if field Id_sale is set (has been assigned a value) and false otherwise */
  public boolean isSetId_sale() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_SALE_ISSET_ID);
  }

  public void setId_saleIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_SALE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case ID_PLANE:
      if (value == null) {
        unsetId_plane();
      } else {
        setId_plane((Integer)value);
      }
      break;

    case PLANENAME:
      if (value == null) {
        unsetPlanename();
      } else {
        setPlanename((String)value);
      }
      break;

    case ID_SALE:
      if (value == null) {
        unsetId_sale();
      } else {
        setId_sale((Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID_PLANE:
      return getId_plane();

    case PLANENAME:
      return getPlanename();

    case ID_SALE:
      return getId_sale();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID_PLANE:
      return isSetId_plane();
    case PLANENAME:
      return isSetPlanename();
    case ID_SALE:
      return isSetId_sale();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof plane)
      return this.equals((plane)that);
    return false;
  }

  public boolean equals(plane that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_Id_plane = true;
    boolean that_present_Id_plane = true;
    if (this_present_Id_plane || that_present_Id_plane) {
      if (!(this_present_Id_plane && that_present_Id_plane))
        return false;
      if (this.Id_plane != that.Id_plane)
        return false;
    }

    boolean this_present_planename = true && this.isSetPlanename();
    boolean that_present_planename = true && that.isSetPlanename();
    if (this_present_planename || that_present_planename) {
      if (!(this_present_planename && that_present_planename))
        return false;
      if (!this.planename.equals(that.planename))
        return false;
    }

    boolean this_present_Id_sale = true;
    boolean that_present_Id_sale = true;
    if (this_present_Id_sale || that_present_Id_sale) {
      if (!(this_present_Id_sale && that_present_Id_sale))
        return false;
      if (this.Id_sale != that.Id_sale)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + Id_plane;

    hashCode = hashCode * 8191 + ((isSetPlanename()) ? 131071 : 524287);
    if (isSetPlanename())
      hashCode = hashCode * 8191 + planename.hashCode();

    hashCode = hashCode * 8191 + Id_sale;

    return hashCode;
  }

  @Override
  public int compareTo(plane other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId_plane()).compareTo(other.isSetId_plane());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_plane()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Id_plane, other.Id_plane);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlanename()).compareTo(other.isSetPlanename());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlanename()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.planename, other.planename);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId_sale()).compareTo(other.isSetId_sale());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_sale()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Id_sale, other.Id_sale);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("plane(");
    boolean first = true;

    sb.append("Id_plane:");
    sb.append(this.Id_plane);
    first = false;
    if (!first) sb.append(", ");
    sb.append("planename:");
    if (this.planename == null) {
      sb.append("null");
    } else {
      sb.append(this.planename);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Id_sale:");
    sb.append(this.Id_sale);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class planeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public planeStandardScheme getScheme() {
      return new planeStandardScheme();
    }
  }

  private static class planeStandardScheme extends org.apache.thrift.scheme.StandardScheme<plane> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, plane struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID_PLANE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Id_plane = iprot.readI32();
              struct.setId_planeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PLANENAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.planename = iprot.readString();
              struct.setPlanenameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ID_SALE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Id_sale = iprot.readI32();
              struct.setId_saleIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, plane struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_PLANE_FIELD_DESC);
      oprot.writeI32(struct.Id_plane);
      oprot.writeFieldEnd();
      if (struct.planename != null) {
        oprot.writeFieldBegin(PLANENAME_FIELD_DESC);
        oprot.writeString(struct.planename);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ID_SALE_FIELD_DESC);
      oprot.writeI32(struct.Id_sale);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class planeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public planeTupleScheme getScheme() {
      return new planeTupleScheme();
    }
  }

  private static class planeTupleScheme extends org.apache.thrift.scheme.TupleScheme<plane> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, plane struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId_plane()) {
        optionals.set(0);
      }
      if (struct.isSetPlanename()) {
        optionals.set(1);
      }
      if (struct.isSetId_sale()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetId_plane()) {
        oprot.writeI32(struct.Id_plane);
      }
      if (struct.isSetPlanename()) {
        oprot.writeString(struct.planename);
      }
      if (struct.isSetId_sale()) {
        oprot.writeI32(struct.Id_sale);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, plane struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.Id_plane = iprot.readI32();
        struct.setId_planeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.planename = iprot.readString();
        struct.setPlanenameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.Id_sale = iprot.readI32();
        struct.setId_saleIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

