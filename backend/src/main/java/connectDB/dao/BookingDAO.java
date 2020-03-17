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


    public List<booking> GetBooking() throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();

        try {
            List<booking> bookinglist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from booking");
            while(rs.next()){
                booking bk=new booking();
                bk.setId_booking(Integer.parseInt(rs.getString("ID_Booking")));
                bk.setFull_name(rs.getString("Full_name"));
                bk.setEmail(rs.getString("Email"));
                bk.setId_plane(Integer.parseInt(rs.getString("ID_Plane")));
                bk.setPhone(rs.getString("Phone"));
                bk.setTimebooking(rs.getString("Timebooking"));
                bk.setDatebooking(rs.getString("Datebooking"));
                bk.setId_sale(Integer.parseInt(rs.getString("ID_sale")));
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
    public List<booking> GetBookingById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();

        try {
            List<booking> bookinglist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from booking where Id_sale="+id);
            while(rs.next()){
                booking bk=new booking();
                bk.setId_booking(Integer.parseInt(rs.getString("ID_Booking")));
                bk.setFull_name(rs.getString("Full_name"));
                bk.setEmail(rs.getString("Email"));
                bk.setId_plane(Integer.parseInt(rs.getString("ID_Plane")));
                bk.setPhone(rs.getString("Phone"));
                bk.setTimebooking(rs.getString("Timebooking"));
                bk.setDatebooking(rs.getString("Datebooking"));
                bk.setId_sale(Integer.parseInt(rs.getString("ID_sale")));
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


    public int InsertBooking(booking book) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement
                    ("INSERT INTO `booking`(`Full_name`, `Email`, `Phone`, `Datebooking`, `ID_Plane`, `Timebooking`,`ID_sale`) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,book.getFull_name());
            ps.setString(2,book.getEmail());
            ps.setString(3,book.getPhone());
            ps.setString(4,book.getDatebooking());
            ps.setInt(5,book.getId_plane());
            ps.setString(6,book.getTimebooking());
            ps.setInt(7,book.getId_sale());
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
