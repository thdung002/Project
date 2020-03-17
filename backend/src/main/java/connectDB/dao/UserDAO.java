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
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("select * from users where Username = '"+usrn+"' and Password='"+pwd+"'");
            while(rs.next()){
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
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from users ");
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

}
