/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package connectDB;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
/**
 * The first thing to know about are types. The available types in Thrift are:
 * 
 *  bool        Boolean, one byte
 *  i8 (byte)   Signed 8-bit integer
 *  i16         Signed 16-bit integer
 *  i32         Signed 32-bit integer
 *  i64         Signed 64-bit integer
 *  double      64-bit floating point value
 *  string      String
 *  binary      Blob (byte array)
 *  map<t1,t2>  Map from one type to another
 *  list<t1>    Ordered list of one type
 *  set<t1>     Set of unique elements of one type
 * 
 * Did you also notice that Thrift supports C style comments?
 */
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-03-18")
public class scheduler implements org.apache.thrift.TBase<scheduler, scheduler._Fields>, java.io.Serializable, Cloneable, Comparable<scheduler> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("scheduler");

  private static final org.apache.thrift.protocol.TField ID_SCHEDULER_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_scheduler", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ID_SALE_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_sale", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField ID_PLANE_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_plane", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField STARTS_FIELD_DESC = new org.apache.thrift.protocol.TField("Starts", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField ENDS_FIELD_DESC = new org.apache.thrift.protocol.TField("Ends", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField DATE_CREATED_FIELD_DESC = new org.apache.thrift.protocol.TField("DateCreated", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new schedulerStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new schedulerTupleSchemeFactory();

  public int Id_scheduler; // required
  public int Id_sale; // required
  public int Id_plane; // required
  public double Starts; // required
  public double Ends; // required
  public @org.apache.thrift.annotation.Nullable String DateCreated; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID_SCHEDULER((short)1, "Id_scheduler"),
    ID_SALE((short)2, "Id_sale"),
    ID_PLANE((short)3, "Id_plane"),
    STARTS((short)4, "Starts"),
    ENDS((short)5, "Ends"),
    DATE_CREATED((short)6, "DateCreated");

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
        case 1: // ID_SCHEDULER
          return ID_SCHEDULER;
        case 2: // ID_SALE
          return ID_SALE;
        case 3: // ID_PLANE
          return ID_PLANE;
        case 4: // STARTS
          return STARTS;
        case 5: // ENDS
          return ENDS;
        case 6: // DATE_CREATED
          return DATE_CREATED;
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
  private static final int __ID_SCHEDULER_ISSET_ID = 0;
  private static final int __ID_SALE_ISSET_ID = 1;
  private static final int __ID_PLANE_ISSET_ID = 2;
  private static final int __STARTS_ISSET_ID = 3;
  private static final int __ENDS_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID_SCHEDULER, new org.apache.thrift.meta_data.FieldMetaData("Id_scheduler", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ID_SALE, new org.apache.thrift.meta_data.FieldMetaData("Id_sale", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ID_PLANE, new org.apache.thrift.meta_data.FieldMetaData("Id_plane", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STARTS, new org.apache.thrift.meta_data.FieldMetaData("Starts", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.ENDS, new org.apache.thrift.meta_data.FieldMetaData("Ends", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.DATE_CREATED, new org.apache.thrift.meta_data.FieldMetaData("DateCreated", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(scheduler.class, metaDataMap);
  }

  public scheduler() {
  }

  public scheduler(
    int Id_scheduler,
    int Id_sale,
    int Id_plane,
    double Starts,
    double Ends,
    String DateCreated)
  {
    this();
    this.Id_scheduler = Id_scheduler;
    setId_schedulerIsSet(true);
    this.Id_sale = Id_sale;
    setId_saleIsSet(true);
    this.Id_plane = Id_plane;
    setId_planeIsSet(true);
    this.Starts = Starts;
    setStartsIsSet(true);
    this.Ends = Ends;
    setEndsIsSet(true);
    this.DateCreated = DateCreated;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public scheduler(scheduler other) {
    __isset_bitfield = other.__isset_bitfield;
    this.Id_scheduler = other.Id_scheduler;
    this.Id_sale = other.Id_sale;
    this.Id_plane = other.Id_plane;
    this.Starts = other.Starts;
    this.Ends = other.Ends;
    if (other.isSetDateCreated()) {
      this.DateCreated = other.DateCreated;
    }
  }

  public scheduler deepCopy() {
    return new scheduler(this);
  }

  @Override
  public void clear() {
    setId_schedulerIsSet(false);
    this.Id_scheduler = 0;
    setId_saleIsSet(false);
    this.Id_sale = 0;
    setId_planeIsSet(false);
    this.Id_plane = 0;
    setStartsIsSet(false);
    this.Starts = 0.0;
    setEndsIsSet(false);
    this.Ends = 0.0;
    this.DateCreated = null;
  }

  public int getId_scheduler() {
    return this.Id_scheduler;
  }

  public scheduler setId_scheduler(int Id_scheduler) {
    this.Id_scheduler = Id_scheduler;
    setId_schedulerIsSet(true);
    return this;
  }

  public void unsetId_scheduler() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_SCHEDULER_ISSET_ID);
  }

  /** Returns true if field Id_scheduler is set (has been assigned a value) and false otherwise */
  public boolean isSetId_scheduler() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_SCHEDULER_ISSET_ID);
  }

  public void setId_schedulerIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_SCHEDULER_ISSET_ID, value);
  }

  public int getId_sale() {
    return this.Id_sale;
  }

  public scheduler setId_sale(int Id_sale) {
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

  public int getId_plane() {
    return this.Id_plane;
  }

  public scheduler setId_plane(int Id_plane) {
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

  public double getStarts() {
    return this.Starts;
  }

  public scheduler setStarts(double Starts) {
    this.Starts = Starts;
    setStartsIsSet(true);
    return this;
  }

  public void unsetStarts() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __STARTS_ISSET_ID);
  }

  /** Returns true if field Starts is set (has been assigned a value) and false otherwise */
  public boolean isSetStarts() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __STARTS_ISSET_ID);
  }

  public void setStartsIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __STARTS_ISSET_ID, value);
  }

  public double getEnds() {
    return this.Ends;
  }

  public scheduler setEnds(double Ends) {
    this.Ends = Ends;
    setEndsIsSet(true);
    return this;
  }

  public void unsetEnds() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ENDS_ISSET_ID);
  }

  /** Returns true if field Ends is set (has been assigned a value) and false otherwise */
  public boolean isSetEnds() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ENDS_ISSET_ID);
  }

  public void setEndsIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ENDS_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public String getDateCreated() {
    return this.DateCreated;
  }

  public scheduler setDateCreated(@org.apache.thrift.annotation.Nullable String DateCreated) {
    this.DateCreated = DateCreated;
    return this;
  }

  public void unsetDateCreated() {
    this.DateCreated = null;
  }

  /** Returns true if field DateCreated is set (has been assigned a value) and false otherwise */
  public boolean isSetDateCreated() {
    return this.DateCreated != null;
  }

  public void setDateCreatedIsSet(boolean value) {
    if (!value) {
      this.DateCreated = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case ID_SCHEDULER:
      if (value == null) {
        unsetId_scheduler();
      } else {
        setId_scheduler((Integer)value);
      }
      break;

    case ID_SALE:
      if (value == null) {
        unsetId_sale();
      } else {
        setId_sale((Integer)value);
      }
      break;

    case ID_PLANE:
      if (value == null) {
        unsetId_plane();
      } else {
        setId_plane((Integer)value);
      }
      break;

    case STARTS:
      if (value == null) {
        unsetStarts();
      } else {
        setStarts((Double)value);
      }
      break;

    case ENDS:
      if (value == null) {
        unsetEnds();
      } else {
        setEnds((Double)value);
      }
      break;

    case DATE_CREATED:
      if (value == null) {
        unsetDateCreated();
      } else {
        setDateCreated((String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID_SCHEDULER:
      return getId_scheduler();

    case ID_SALE:
      return getId_sale();

    case ID_PLANE:
      return getId_plane();

    case STARTS:
      return getStarts();

    case ENDS:
      return getEnds();

    case DATE_CREATED:
      return getDateCreated();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID_SCHEDULER:
      return isSetId_scheduler();
    case ID_SALE:
      return isSetId_sale();
    case ID_PLANE:
      return isSetId_plane();
    case STARTS:
      return isSetStarts();
    case ENDS:
      return isSetEnds();
    case DATE_CREATED:
      return isSetDateCreated();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof scheduler)
      return this.equals((scheduler)that);
    return false;
  }

  public boolean equals(scheduler that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_Id_scheduler = true;
    boolean that_present_Id_scheduler = true;
    if (this_present_Id_scheduler || that_present_Id_scheduler) {
      if (!(this_present_Id_scheduler && that_present_Id_scheduler))
        return false;
      if (this.Id_scheduler != that.Id_scheduler)
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

    boolean this_present_Id_plane = true;
    boolean that_present_Id_plane = true;
    if (this_present_Id_plane || that_present_Id_plane) {
      if (!(this_present_Id_plane && that_present_Id_plane))
        return false;
      if (this.Id_plane != that.Id_plane)
        return false;
    }

    boolean this_present_Starts = true;
    boolean that_present_Starts = true;
    if (this_present_Starts || that_present_Starts) {
      if (!(this_present_Starts && that_present_Starts))
        return false;
      if (this.Starts != that.Starts)
        return false;
    }

    boolean this_present_Ends = true;
    boolean that_present_Ends = true;
    if (this_present_Ends || that_present_Ends) {
      if (!(this_present_Ends && that_present_Ends))
        return false;
      if (this.Ends != that.Ends)
        return false;
    }

    boolean this_present_DateCreated = true && this.isSetDateCreated();
    boolean that_present_DateCreated = true && that.isSetDateCreated();
    if (this_present_DateCreated || that_present_DateCreated) {
      if (!(this_present_DateCreated && that_present_DateCreated))
        return false;
      if (!this.DateCreated.equals(that.DateCreated))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + Id_scheduler;

    hashCode = hashCode * 8191 + Id_sale;

    hashCode = hashCode * 8191 + Id_plane;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(Starts);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(Ends);

    hashCode = hashCode * 8191 + ((isSetDateCreated()) ? 131071 : 524287);
    if (isSetDateCreated())
      hashCode = hashCode * 8191 + DateCreated.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(scheduler other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId_scheduler()).compareTo(other.isSetId_scheduler());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_scheduler()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Id_scheduler, other.Id_scheduler);
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
    lastComparison = Boolean.valueOf(isSetStarts()).compareTo(other.isSetStarts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStarts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Starts, other.Starts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnds()).compareTo(other.isSetEnds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Ends, other.Ends);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDateCreated()).compareTo(other.isSetDateCreated());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDateCreated()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.DateCreated, other.DateCreated);
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
    StringBuilder sb = new StringBuilder("scheduler(");
    boolean first = true;

    sb.append("Id_scheduler:");
    sb.append(this.Id_scheduler);
    first = false;
    if (!first) sb.append(", ");
    sb.append("Id_sale:");
    sb.append(this.Id_sale);
    first = false;
    if (!first) sb.append(", ");
    sb.append("Id_plane:");
    sb.append(this.Id_plane);
    first = false;
    if (!first) sb.append(", ");
    sb.append("Starts:");
    sb.append(this.Starts);
    first = false;
    if (!first) sb.append(", ");
    sb.append("Ends:");
    sb.append(this.Ends);
    first = false;
    if (!first) sb.append(", ");
    sb.append("DateCreated:");
    if (this.DateCreated == null) {
      sb.append("null");
    } else {
      sb.append(this.DateCreated);
    }
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

  private static class schedulerStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public schedulerStandardScheme getScheme() {
      return new schedulerStandardScheme();
    }
  }

  private static class schedulerStandardScheme extends org.apache.thrift.scheme.StandardScheme<scheduler> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, scheduler struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID_SCHEDULER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Id_scheduler = iprot.readI32();
              struct.setId_schedulerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ID_SALE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Id_sale = iprot.readI32();
              struct.setId_saleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ID_PLANE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Id_plane = iprot.readI32();
              struct.setId_planeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STARTS
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.Starts = iprot.readDouble();
              struct.setStartsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ENDS
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.Ends = iprot.readDouble();
              struct.setEndsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // DATE_CREATED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.DateCreated = iprot.readString();
              struct.setDateCreatedIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, scheduler struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_SCHEDULER_FIELD_DESC);
      oprot.writeI32(struct.Id_scheduler);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ID_SALE_FIELD_DESC);
      oprot.writeI32(struct.Id_sale);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ID_PLANE_FIELD_DESC);
      oprot.writeI32(struct.Id_plane);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STARTS_FIELD_DESC);
      oprot.writeDouble(struct.Starts);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ENDS_FIELD_DESC);
      oprot.writeDouble(struct.Ends);
      oprot.writeFieldEnd();
      if (struct.DateCreated != null) {
        oprot.writeFieldBegin(DATE_CREATED_FIELD_DESC);
        oprot.writeString(struct.DateCreated);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class schedulerTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public schedulerTupleScheme getScheme() {
      return new schedulerTupleScheme();
    }
  }

  private static class schedulerTupleScheme extends org.apache.thrift.scheme.TupleScheme<scheduler> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, scheduler struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId_scheduler()) {
        optionals.set(0);
      }
      if (struct.isSetId_sale()) {
        optionals.set(1);
      }
      if (struct.isSetId_plane()) {
        optionals.set(2);
      }
      if (struct.isSetStarts()) {
        optionals.set(3);
      }
      if (struct.isSetEnds()) {
        optionals.set(4);
      }
      if (struct.isSetDateCreated()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetId_scheduler()) {
        oprot.writeI32(struct.Id_scheduler);
      }
      if (struct.isSetId_sale()) {
        oprot.writeI32(struct.Id_sale);
      }
      if (struct.isSetId_plane()) {
        oprot.writeI32(struct.Id_plane);
      }
      if (struct.isSetStarts()) {
        oprot.writeDouble(struct.Starts);
      }
      if (struct.isSetEnds()) {
        oprot.writeDouble(struct.Ends);
      }
      if (struct.isSetDateCreated()) {
        oprot.writeString(struct.DateCreated);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, scheduler struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.Id_scheduler = iprot.readI32();
        struct.setId_schedulerIsSet(true);
      }
      if (incoming.get(1)) {
        struct.Id_sale = iprot.readI32();
        struct.setId_saleIsSet(true);
      }
      if (incoming.get(2)) {
        struct.Id_plane = iprot.readI32();
        struct.setId_planeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.Starts = iprot.readDouble();
        struct.setStartsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.Ends = iprot.readDouble();
        struct.setEndsIsSet(true);
      }
      if (incoming.get(5)) {
        struct.DateCreated = iprot.readString();
        struct.setDateCreatedIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

