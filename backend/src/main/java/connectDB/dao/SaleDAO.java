package connectDB.dao;
import connectDB.sale;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;
import java.lang.*;

import static java.lang.Class.forName;
import static connectDB.jdbc.createConnection.getConnection;
public class SaleDAO {

    //init the singleton
    private static volatile SaleDAO instance;
    public static SaleDAO getInstance() {
        if (instance == null) {
            synchronized (SaleDAO.class) {
                if (instance == null) {
                    instance = new SaleDAO();
                }
            }
        }
        return instance;
    }
    ///end of init


    public List<sale> getSalelist() throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {
            List<sale> salelist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from sale");
            while(rs.next()){
                sale sl=new sale();
                sl.setId(rs.getInt("ID_Sale"));
                sl.setDate(rs.getString("Date"));
                sl.setPlane(rs.getString("Plane"));
                sl.setStarts(rs.getString("starts"));
                sl.setEnds(rs.getString("ends"));
                sl.setId_plane(rs.getString("ID_Plane"));
                salelist.add(sl);
            }
            return salelist;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        finally{
            conn.close();
        }

    }
    public List<sale> getSalebyID(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {
            List<sale> salelist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from sale where ID_Sale = '"+id+"'");
            while(rs.next()){
                sale sl=new sale();
                sl.setId(rs.getInt("ID_Sale"));
                sl.setDate(rs.getString("Date"));
                sl.setPlane(rs.getString("Plane"));
                sl.setStarts(rs.getString("starts"));
                sl.setEnds(rs.getString("ends"));
                sl.setId_plane(rs.getString("ID_Plane"));

                salelist.add(sl);
            }
            return salelist;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        finally{
            conn.close();
        }



    }
    public int insertSale(sale saleinfo) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement
                ("INSERT INTO `sale`(`ID_sale`, `Date`, `ID_Plane`, `Plane`, `starts`, `ends`) VALUES (?,?,?,?,?,?)");
            ps.setInt(1,saleinfo.getId());
            ps.setString(2,saleinfo.getDate());
            ps.setString(4,saleinfo.getPlane());
            ps.setString(5,saleinfo.getStarts());
            ps.setString(6,saleinfo.getEnds());
            ps.setString(3,saleinfo.getId_plane());
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
