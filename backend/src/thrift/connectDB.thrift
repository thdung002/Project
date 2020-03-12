namespace java connectDB
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
struct sale{
    1: i32 id,
    2: string date,
    3: string plane,
    4: string starts,
    5: string ends,
    6: string id_plane
}
struct users{
    1: i32 id_sale,
    2: string username,
    3: string password,
    4: string Firstname,
    5: string Lastname
}
struct booking{
    1: string full_name,
    2: string email,
    3: string phone,
    4: string date,
    5: string id_plane,
    6: string time,
}

struct plane{
    1: string id_plane;
    2: string planename;
}

service connectDBService{
    list<sale> getSale(),//ok
    list<sale> getSalebyID(1: i32 id),//ok
    users getUsers(1: string usr, 2: string pwd),//ok
    list<booking> getBooking(),//ok
    list<plane> getPlane(),//ok
    i32 insertBooking(1:booking infor),//ok
    i32 insertSale(1:sale saleinfo)//ok
}