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
struct scheduler{
    1: i32 Id_scheduler,
    2: i32 Id_sale,
    3: i32 Id_plane ,
    4: double Starts,
    5: double Ends,
    6: string DateCreated
}
struct users{
    1: i32 Id_sale,
    2: string username,
    3: string password,
    4: string Fullname,
    5: i32 AccountType
}
struct booking{
    1: i32 Id_booking
    2: string Full_name,
    3: string Email,
    4: string Phone,
    5: string Datebooking,
    6: i32 Id_plane,
    7: double Timebooking,
    8: i32 Id_sale
}

struct plane{
    1: i32 Id_plane,
    2: string planename,
    3: i32 Id_sale
}

service connectDBService{
    list<scheduler> GetScheduler(),//ok
    list<scheduler> GetSchedulerById(1: i32 id),//ok
    users GetUsers(1: string usr, 2: string pwd),//ok
    list<booking> GetBooking(),//ok
    list<booking> GetBookingById(1:i32 id),//ok
    list<plane> GetPlaneForUser(),//ok
    list<plane> GetPlane(1:i32 id),//ok
    i32 InsertBooking(1:booking infor),//ok
    i32 InsertScheduler(1:scheduler schedul),//ok
    i32 InsertPlane(1:plane pl),
    i32 UpdateScheduler(1:scheduler schedul),
    i32 UpdatePlane(1:i32 id_plane, 2:i32 id_sale),
    i32 InsertOrUpdateScheduler(1:scheduler schedul),
    list<users> GetListSale(),
    list<users> GetAllUser(),
    list<plane> GetAllPlane(),

}