package connectDB.dao;
import java.sql.*;
import java.util.*;
import java.lang.*;
import connectDB.booking;
import static connectDB.jdbc.createConnection.*;

public class BookingDAO {

    //init the singleton
private static volatile BookingDAO instance;
public static BookingDAO getInstance() {
    if (instance == null) {
        synchronized (BookingDAO.class) {
            if (instance == null) {
                instance = new BookingDAO();
            }
        }
    }
    return instance;
}
    ///end of init


    public List<booking> getBooking() throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();

        try {
            List<booking> bookinglist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from booking");
            while(rs.next()){
                booking bk=new booking();
                bk.setFull_name(rs.getString("Full_name"));
                bk.setEmail(rs.getString("Email"));
                bk.setId_plane(rs.getString("ID_Plane"));
                bk.setPhone(rs.getString("Phone"));
                bk.setTime(rs.getString("Time"));
                bk.setDate(rs.getString("Date"));
                bookinglist.add(bk);
            }
            return bookinglist;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        finally{
            conn.close();
        }


    }
    public int insertBooking(booking book) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement
                    ("INSERT INTO `booking`(`Full_name`, `Email`, `Phone`, `Date`, `ID_Plane`, `Time`) VALUES (?,?,?,?,?,?)");
            ps.setString(1,book.getFull_name());
            ps.setString(2,book.getEmail());
            ps.setString(3,book.getPhone());
            ps.setString(4,book.getDate());
            ps.setString(5,book.getId_plane());
            ps.setString(6,book.getTime());
            ps.executeUpdate();
            return 1;
        }
        catch (SQLException e) {
            System.out.println(e.toString());
            return -1;
        }
        finally{
            conn.close();
        }


    }


}
