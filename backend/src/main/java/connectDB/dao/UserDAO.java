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
                userlst.setFirstname(rs.getString("First_name"));
                userlst.setLastname(rs.getString("Last_name"));
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

}
