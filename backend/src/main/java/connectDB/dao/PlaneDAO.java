package connectDB.dao;
import connectDB.plane;
import java.sql.*;
import java.util.*;
import java.lang.*;

import static connectDB.jdbc.createConnection.getConnection;

public class PlaneDAO {
    //init the singleton
    private static volatile PlaneDAO instance;
    public static PlaneDAO getInstance() {
        if (instance == null) {
            synchronized (PlaneDAO.class) {
                if (instance == null) {
                    instance = new PlaneDAO();
                }
            }
        }
        return instance;
    }
    ///end of init


    public List<plane> getPlane() throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();

        try {

            List<plane> planelist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from plane");
            while(rs.next()){
                plane pl=new plane();
                pl.setId_plane(rs.getString("ID_Plane"));
                pl.setPlanename(rs.getString("Plane"));
                planelist.add(pl);
            }
            return planelist;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        finally{
            conn.close();
        }


    }

}
