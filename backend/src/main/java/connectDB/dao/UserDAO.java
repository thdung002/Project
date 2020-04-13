package connectDB.dao;
import connectDB.users;

import java.sql.*;
import java.util.*;
import java.lang.*;
import static connectDB.jdbc.createConnection.*;

public class UserDAO {

    //init the singleton
    private static volatile UserDAO instance;
    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }
    ///end of init

    public users getUserLogin(String usrn, String pwd) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {
            users userlst = new users();
            PreparedStatement ps = conn.prepareStatement("select * from users where Username =? and Password=?");
            ps.setString(1,usrn);
            ps.setString(2,pwd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                userlst.setId_sale(rs.getInt("ID_Sale"));
                userlst.setUsername(rs.getString("Username"));
                userlst.setPassword(rs.getString("Password"));
                userlst.setFullname(rs.getString("Full_Name"));
                userlst.setAccountType(Integer.parseInt(rs.getString("AccountType")));
            }
            return userlst;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        finally{
            conn.close();
        }

    }
    public List<users> GetListSale() throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {

            List<users> usrlist = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                users usr=new users();
                usr.setId_sale(Integer.parseInt(rs.getString("ID_Sale")));
                usr.setFullname(rs.getString("Full_Name"));
//                usr.setUsername("NOT AVAILABLE");
//                usr.setPassword("NOT AVAILABLE");
//                usr.setAccountType(-1);
                usrlist.add(usr);
            }
            return usrlist;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        finally{
            conn.close();
        }
    }
    public List<users> GetAllUser() throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {

            List<users> usrlist = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                users usr=new users();
                usr.setId_sale(Integer.parseInt(rs.getString("ID_Sale")));
                usr.setFullname(rs.getString("Full_Name"));
                usr.setUsername(rs.getString("Username"));
                usr.setPassword(rs.getString("Password"));
                usr.setAccountType(rs.getInt("AccountType"));
                usrlist.add(usr);
            }
            return usrlist;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        finally{
            conn.close();
        }
    }
    public int DeleteUser(int id) throws SQLException, ClassNotFoundException{
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM `users` WHERE ID_Sale=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return -1;
        }
        finally{
            conn.close();
        }
    }

    public int InsertUser(users usr) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement
                    ("INSERT INTO `users`(`Full_Name`, `Username`, `Password`, `AccountType`) VALUES (?,?,?,?)");
            ps.setString(1,usr.getFullname());
            ps.setString(2,usr.getUsername());
            ps.setString(3,usr.getPassword());
            ps.setInt(4,usr.getAccountType());
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
