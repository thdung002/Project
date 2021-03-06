/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package connectDB;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-04-09")
public class booking implements org.apache.thrift.TBase<booking, booking._Fields>, java.io.Serializable, Cloneable, Comparable<booking> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("booking");

  private static final org.apache.thrift.protocol.TField ID_BOOKING_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_booking", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField FULL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("Full_name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField EMAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("Email", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PHONE_FIELD_DESC = new org.apache.thrift.protocol.TField("Phone", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField DATEBOOKING_FIELD_DESC = new org.apache.thrift.protocol.TField("Datebooking", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField ID_PLANE_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_plane", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField TIMEBOOKING_FIELD_DESC = new org.apache.thrift.protocol.TField("Timebooking", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField ID_SALE_FIELD_DESC = new org.apache.thrift.protocol.TField("Id_sale", org.apache.thrift.protocol.TType.I32, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new bookingStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new bookingTupleSchemeFactory();

  public int Id_booking; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Full_name; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Email; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Phone; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Datebooking; // required
  public int Id_plane; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String Timebooking; // required
  public int Id_sale; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID_BOOKING((short)1, "Id_booking"),
    FULL_NAME((short)2, "Full_name"),
    EMAIL((short)3, "Email"),
    PHONE((short)4, "Phone"),
    DATEBOOKING((short)5, "Datebooking"),
    ID_PLANE((short)6, "Id_plane"),
    TIMEBOOKING((short)7, "Timebooking"),
    ID_SALE((short)8, "Id_sale");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

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
        case 1: // ID_BOOKING
          return ID_BOOKING;
        case 2: // FULL_NAME
          return FULL_NAME;
        case 3: // EMAIL
          return EMAIL;
        case 4: // PHONE
          return PHONE;
        case 5: // DATEBOOKING
          return DATEBOOKING;
        case 6: // ID_PLANE
          return ID_PLANE;
        case 7: // TIMEBOOKING
          return TIMEBOOKING;
        case 8: // ID_SALE
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_BOOKING_ISSET_ID = 0;
  private static final int __ID_PLANE_ISSET_ID = 1;
  private static final int __ID_SALE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID_BOOKING, new org.apache.thrift.meta_data.FieldMetaData("Id_booking", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FULL_NAME, new org.apache.thrift.meta_data.FieldMetaData("Full_name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EMAIL, new org.apache.thrift.meta_data.FieldMetaData("Email", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PHONE, new org.apache.thrift.meta_data.FieldMetaData("Phone", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATEBOOKING, new org.apache.thrift.meta_data.FieldMetaData("Datebooking", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_PLANE, new org.apache.thrift.meta_data.FieldMetaData("Id_plane", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TIMEBOOKING, new org.apache.thrift.meta_data.FieldMetaData("Timebooking", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ID_SALE, new org.apache.thrift.meta_data.FieldMetaData("Id_sale", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(booking.class, metaDataMap);
  }

  public booking() {
  }

  public booking(
    int Id_booking,
    java.lang.String Full_name,
    java.lang.String Email,
    java.lang.String Phone,
    java.lang.String Datebooking,
    int Id_plane,
    java.lang.String Timebooking,
    int Id_sale)
  {
    this();
    this.Id_booking = Id_booking;
    setId_bookingIsSet(true);
    this.Full_name = Full_name;
    this.Email = Email;
    this.Phone = Phone;
    this.Datebooking = Datebooking;
    this.Id_plane = Id_plane;
    setId_planeIsSet(true);
    this.Timebooking = Timebooking;
    this.Id_sale = Id_sale;
    setId_saleIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public booking(booking other) {
    __isset_bitfield = other.__isset_bitfield;
    this.Id_booking = other.Id_booking;
    if (other.isSetFull_name()) {
      this.Full_name = other.Full_name;
    }
    if (other.isSetEmail()) {
      this.Email = other.Email;
    }
    if (other.isSetPhone()) {
      this.Phone = other.Phone;
    }
    if (other.isSetDatebooking()) {
      this.Datebooking = other.Datebooking;
    }
    this.Id_plane = other.Id_plane;
    if (other.isSetTimebooking()) {
      this.Timebooking = other.Timebooking;
    }
    this.Id_sale = other.Id_sale;
  }

  public booking deepCopy() {
    return new booking(this);
  }

  @Override
  public void clear() {
    setId_bookingIsSet(false);
    this.Id_booking = 0;
    this.Full_name = null;
    this.Email = null;
    this.Phone = null;
    this.Datebooking = null;
    setId_planeIsSet(false);
    this.Id_plane = 0;
    this.Timebooking = null;
    setId_saleIsSet(false);
    this.Id_sale = 0;
  }

  public int getId_booking() {
    return this.Id_booking;
  }

  public booking setId_booking(int Id_booking) {
    this.Id_booking = Id_booking;
    setId_bookingIsSet(true);
    return this;
  }

  public void unsetId_booking() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_BOOKING_ISSET_ID);
  }

  /** Returns true if field Id_booking is set (has been assigned a value) and false otherwise */
  public boolean isSetId_booking() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_BOOKING_ISSET_ID);
  }

  public void setId_bookingIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_BOOKING_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getFull_name() {
    return this.Full_name;
  }

  public booking setFull_name(@org.apache.thrift.annotation.Nullable java.lang.String Full_name) {
    this.Full_name = Full_name;
    return this;
  }

  public void unsetFull_name() {
    this.Full_name = null;
  }

  /** Returns true if field Full_name is set (has been assigned a value) and false otherwise */
  public boolean isSetFull_name() {
    return this.Full_name != null;
  }

  public void setFull_nameIsSet(boolean value) {
    if (!value) {
      this.Full_name = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEmail() {
    return this.Email;
  }

  public booking setEmail(@org.apache.thrift.annotation.Nullable java.lang.String Email) {
    this.Email = Email;
    return this;
  }

  public void unsetEmail() {
    this.Email = null;
  }

  /** Returns true if field Email is set (has been assigned a value) and false otherwise */
  public boolean isSetEmail() {
    return this.Email != null;
  }

  public void setEmailIsSet(boolean value) {
    if (!value) {
      this.Email = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPhone() {
    return this.Phone;
  }

  public booking setPhone(@org.apache.thrift.annotation.Nullable java.lang.String Phone) {
    this.Phone = Phone;
    return this;
  }

  public void unsetPhone() {
    this.Phone = null;
  }

  /** Returns true if field Phone is set (has been assigned a value) and false otherwise */
  public boolean isSetPhone() {
    return this.Phone != null;
  }

  public void setPhoneIsSet(boolean value) {
    if (!value) {
      this.Phone = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getDatebooking() {
    return this.Datebooking;
  }

  public booking setDatebooking(@org.apache.thrift.annotation.Nullable java.lang.String Datebooking) {
    this.Datebooking = Datebooking;
    return this;
  }

  public void unsetDatebooking() {
    this.Datebooking = null;
  }

  /** Returns true if field Datebooking is set (has been assigned a value) and false otherwise */
  public boolean isSetDatebooking() {
    return this.Datebooking != null;
  }

  public void setDatebookingIsSet(boolean value) {
    if (!value) {
      this.Datebooking = null;
    }
  }

  public int getId_plane() {
    return this.Id_plane;
  }

  public booking setId_plane(int Id_plane) {
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
  public java.lang.String getTimebooking() {
    return this.Timebooking;
  }

  public booking setTimebooking(@org.apache.thrift.annotation.Nullable java.lang.String Timebooking) {
    this.Timebooking = Timebooking;
    return this;
  }

  public void unsetTimebooking() {
    this.Timebooking = null;
  }

  /** Returns true if field Timebooking is set (has been assigned a value) and false otherwise */
  public boolean isSetTimebooking() {
    return this.Timebooking != null;
  }

  public void setTimebookingIsSet(boolean value) {
    if (!value) {
      this.Timebooking = null;
    }
  }

  public int getId_sale() {
    return this.Id_sale;
  }

  public booking setId_sale(int Id_sale) {
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

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ID_BOOKING:
      if (value == null) {
        unsetId_booking();
      } else {
        setId_booking((java.lang.Integer)value);
      }
      break;

    case FULL_NAME:
      if (value == null) {
        unsetFull_name();
      } else {
        setFull_name((java.lang.String)value);
      }
      break;

    case EMAIL:
      if (value == null) {
        unsetEmail();
      } else {
        setEmail((java.lang.String)value);
      }
      break;

    case PHONE:
      if (value == null) {
        unsetPhone();
      } else {
        setPhone((java.lang.String)value);
      }
      break;

    case DATEBOOKING:
      if (value == null) {
        unsetDatebooking();
      } else {
        setDatebooking((java.lang.String)value);
      }
      break;

    case ID_PLANE:
      if (value == null) {
        unsetId_plane();
      } else {
        setId_plane((java.lang.Integer)value);
      }
      break;

    case TIMEBOOKING:
      if (value == null) {
        unsetTimebooking();
      } else {
        setTimebooking((java.lang.String)value);
      }
      break;

    case ID_SALE:
      if (value == null) {
        unsetId_sale();
      } else {
        setId_sale((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID_BOOKING:
      return getId_booking();

    case FULL_NAME:
      return getFull_name();

    case EMAIL:
      return getEmail();

    case PHONE:
      return getPhone();

    case DATEBOOKING:
      return getDatebooking();

    case ID_PLANE:
      return getId_plane();

    case TIMEBOOKING:
      return getTimebooking();

    case ID_SALE:
      return getId_sale();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID_BOOKING:
      return isSetId_booking();
    case FULL_NAME:
      return isSetFull_name();
    case EMAIL:
      return isSetEmail();
    case PHONE:
      return isSetPhone();
    case DATEBOOKING:
      return isSetDatebooking();
    case ID_PLANE:
      return isSetId_plane();
    case TIMEBOOKING:
      return isSetTimebooking();
    case ID_SALE:
      return isSetId_sale();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof booking)
      return this.equals((booking)that);
    return false;
  }

  public boolean equals(booking that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_Id_booking = true;
    boolean that_present_Id_booking = true;
    if (this_present_Id_booking || that_present_Id_booking) {
      if (!(this_present_Id_booking && that_present_Id_booking))
        return false;
      if (this.Id_booking != that.Id_booking)
        return false;
    }

    boolean this_present_Full_name = true && this.isSetFull_name();
    boolean that_present_Full_name = true && that.isSetFull_name();
    if (this_present_Full_name || that_present_Full_name) {
      if (!(this_present_Full_name && that_present_Full_name))
        return false;
      if (!this.Full_name.equals(that.Full_name))
        return false;
    }

    boolean this_present_Email = true && this.isSetEmail();
    boolean that_present_Email = true && that.isSetEmail();
    if (this_present_Email || that_present_Email) {
      if (!(this_present_Email && that_present_Email))
        return false;
      if (!this.Email.equals(that.Email))
        return false;
    }

    boolean this_present_Phone = true && this.isSetPhone();
    boolean that_present_Phone = true && that.isSetPhone();
    if (this_present_Phone || that_present_Phone) {
      if (!(this_present_Phone && that_present_Phone))
        return false;
      if (!this.Phone.equals(that.Phone))
        return false;
    }

    boolean this_present_Datebooking = true && this.isSetDatebooking();
    boolean that_present_Datebooking = true && that.isSetDatebooking();
    if (this_present_Datebooking || that_present_Datebooking) {
      if (!(this_present_Datebooking && that_present_Datebooking))
        return false;
      if (!this.Datebooking.equals(that.Datebooking))
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

    boolean this_present_Timebooking = true && this.isSetTimebooking();
    boolean that_present_Timebooking = true && that.isSetTimebooking();
    if (this_present_Timebooking || that_present_Timebooking) {
      if (!(this_present_Timebooking && that_present_Timebooking))
        return false;
      if (!this.Timebooking.equals(that.Timebooking))
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

    hashCode = hashCode * 8191 + Id_booking;

    hashCode = hashCode * 8191 + ((isSetFull_name()) ? 131071 : 524287);
    if (isSetFull_name())
      hashCode = hashCode * 8191 + Full_name.hashCode();

    hashCode = hashCode * 8191 + ((isSetEmail()) ? 131071 : 524287);
    if (isSetEmail())
      hashCode = hashCode * 8191 + Email.hashCode();

    hashCode = hashCode * 8191 + ((isSetPhone()) ? 131071 : 524287);
    if (isSetPhone())
      hashCode = hashCode * 8191 + Phone.hashCode();

    hashCode = hashCode * 8191 + ((isSetDatebooking()) ? 131071 : 524287);
    if (isSetDatebooking())
      hashCode = hashCode * 8191 + Datebooking.hashCode();

    hashCode = hashCode * 8191 + Id_plane;

    hashCode = hashCode * 8191 + ((isSetTimebooking()) ? 131071 : 524287);
    if (isSetTimebooking())
      hashCode = hashCode * 8191 + Timebooking.hashCode();

    hashCode = hashCode * 8191 + Id_sale;

    return hashCode;
  }

  @Override
  public int compareTo(booking other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId_booking()).compareTo(other.isSetId_booking());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_booking()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Id_booking, other.Id_booking);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFull_name()).compareTo(other.isSetFull_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFull_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Full_name, other.Full_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEmail()).compareTo(other.isSetEmail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmail()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Email, other.Email);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPhone()).compareTo(other.isSetPhone());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPhone()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Phone, other.Phone);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDatebooking()).compareTo(other.isSetDatebooking());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDatebooking()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Datebooking, other.Datebooking);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetId_plane()).compareTo(other.isSetId_plane());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId_plane()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Id_plane, other.Id_plane);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTimebooking()).compareTo(other.isSetTimebooking());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimebooking()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Timebooking, other.Timebooking);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetId_sale()).compareTo(other.isSetId_sale());
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
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("booking(");
    boolean first = true;

    sb.append("Id_booking:");
    sb.append(this.Id_booking);
    first = false;
    if (!first) sb.append(", ");
    sb.append("Full_name:");
    if (this.Full_name == null) {
      sb.append("null");
    } else {
      sb.append(this.Full_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Email:");
    if (this.Email == null) {
      sb.append("null");
    } else {
      sb.append(this.Email);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Phone:");
    if (this.Phone == null) {
      sb.append("null");
    } else {
      sb.append(this.Phone);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Datebooking:");
    if (this.Datebooking == null) {
      sb.append("null");
    } else {
      sb.append(this.Datebooking);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Id_plane:");
    sb.append(this.Id_plane);
    first = false;
    if (!first) sb.append(", ");
    sb.append("Timebooking:");
    if (this.Timebooking == null) {
      sb.append("null");
    } else {
      sb.append(this.Timebooking);
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class bookingStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public bookingStandardScheme getScheme() {
      return new bookingStandardScheme();
    }
  }

  private static class bookingStandardScheme extends org.apache.thrift.scheme.StandardScheme<booking> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, booking struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID_BOOKING
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Id_booking = iprot.readI32();
              struct.setId_bookingIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FULL_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Full_name = iprot.readString();
              struct.setFull_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EMAIL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Email = iprot.readString();
              struct.setEmailIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PHONE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Phone = iprot.readString();
              struct.setPhoneIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // DATEBOOKING
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Datebooking = iprot.readString();
              struct.setDatebookingIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ID_PLANE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Id_plane = iprot.readI32();
              struct.setId_planeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // TIMEBOOKING
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Timebooking = iprot.readString();
              struct.setTimebookingIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // ID_SALE
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, booking struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_BOOKING_FIELD_DESC);
      oprot.writeI32(struct.Id_booking);
      oprot.writeFieldEnd();
      if (struct.Full_name != null) {
        oprot.writeFieldBegin(FULL_NAME_FIELD_DESC);
        oprot.writeString(struct.Full_name);
        oprot.writeFieldEnd();
      }
      if (struct.Email != null) {
        oprot.writeFieldBegin(EMAIL_FIELD_DESC);
        oprot.writeString(struct.Email);
        oprot.writeFieldEnd();
      }
      if (struct.Phone != null) {
        oprot.writeFieldBegin(PHONE_FIELD_DESC);
        oprot.writeString(struct.Phone);
        oprot.writeFieldEnd();
      }
      if (struct.Datebooking != null) {
        oprot.writeFieldBegin(DATEBOOKING_FIELD_DESC);
        oprot.writeString(struct.Datebooking);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ID_PLANE_FIELD_DESC);
      oprot.writeI32(struct.Id_plane);
      oprot.writeFieldEnd();
      if (struct.Timebooking != null) {
        oprot.writeFieldBegin(TIMEBOOKING_FIELD_DESC);
        oprot.writeString(struct.Timebooking);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ID_SALE_FIELD_DESC);
      oprot.writeI32(struct.Id_sale);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class bookingTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public bookingTupleScheme getScheme() {
      return new bookingTupleScheme();
    }
  }

  private static class bookingTupleScheme extends org.apache.thrift.scheme.TupleScheme<booking> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, booking struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId_booking()) {
        optionals.set(0);
      }
      if (struct.isSetFull_name()) {
        optionals.set(1);
      }
      if (struct.isSetEmail()) {
        optionals.set(2);
      }
      if (struct.isSetPhone()) {
        optionals.set(3);
      }
      if (struct.isSetDatebooking()) {
        optionals.set(4);
      }
      if (struct.isSetId_plane()) {
        optionals.set(5);
      }
      if (struct.isSetTimebooking()) {
        optionals.set(6);
      }
      if (struct.isSetId_sale()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetId_booking()) {
        oprot.writeI32(struct.Id_booking);
      }
      if (struct.isSetFull_name()) {
        oprot.writeString(struct.Full_name);
      }
      if (struct.isSetEmail()) {
        oprot.writeString(struct.Email);
      }
      if (struct.isSetPhone()) {
        oprot.writeString(struct.Phone);
      }
      if (struct.isSetDatebooking()) {
        oprot.writeString(struct.Datebooking);
      }
      if (struct.isSetId_plane()) {
        oprot.writeI32(struct.Id_plane);
      }
      if (struct.isSetTimebooking()) {
        oprot.writeString(struct.Timebooking);
      }
      if (struct.isSetId_sale()) {
        oprot.writeI32(struct.Id_sale);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, booking struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.Id_booking = iprot.readI32();
        struct.setId_bookingIsSet(true);
      }
      if (incoming.get(1)) {
        struct.Full_name = iprot.readString();
        struct.setFull_nameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.Email = iprot.readString();
        struct.setEmailIsSet(true);
      }
      if (incoming.get(3)) {
        struct.Phone = iprot.readString();
        struct.setPhoneIsSet(true);
      }
      if (incoming.get(4)) {
        struct.Datebooking = iprot.readString();
        struct.setDatebookingIsSet(true);
      }
      if (incoming.get(5)) {
        struct.Id_plane = iprot.readI32();
        struct.setId_planeIsSet(true);
      }
      if (incoming.get(6)) {
        struct.Timebooking = iprot.readString();
        struct.setTimebookingIsSet(true);
      }
      if (incoming.get(7)) {
        struct.Id_sale = iprot.readI32();
        struct.setId_saleIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

