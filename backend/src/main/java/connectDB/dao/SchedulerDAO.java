package connectDB.dao;
import connectDB.scheduler;

import java.sql.*;
import java.util.*;
import java.lang.*;

import static java.lang.Class.forName;
import static connectDB.jdbc.createConnection.getConnection;

public class SchedulerDAO {
    private static volatile SchedulerDAO instance;
    public static SchedulerDAO getInstance() {
        if (instance == null) {
            synchronized (SchedulerDAO.class) {
                if (instance == null) {
                    instance = new SchedulerDAO();
                }
            }
        }
        return instance;
    }
public List<scheduler> GetScheduler() throws SQLException, ClassNotFoundException{
    Connection conn = getConnection();
    try {
        List<scheduler> salelist = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from scheduler");
        while(rs.next()){
            scheduler sl=new scheduler();
            sl.setId_scheduler(rs.getInt("ID_Scheduler"));
            sl.setId_sale(rs.getInt("ID_Sale"));
            sl.setId_plane(rs.getInt("ID_Plane"));
            sl.setStarts(rs.getDouble("Starts"));
            sl.setEnds(rs.getDouble("Ends"));
            sl.setDateCreated(rs.getString("DateCreated"));
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
    public List<scheduler> GetSchedulerByID(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {
            List<scheduler> salelist = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement("select * from scheduler where ID_Sale =?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                scheduler sl=new scheduler();
                sl.setId_sale(rs.getInt("ID_Sale"));
                sl.setDateCreated(rs.getString("DateCreated"));
                sl.setId_scheduler(rs.getInt("ID_Scheduler"));
                sl.setStarts(rs.getDouble("Starts"));
                sl.setEnds(rs.getDouble("Ends"));
                sl.setId_plane(rs.getInt("ID_Plane"));

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
    public int InsertScheduler(scheduler schedu) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement
                    ("INSERT INTO `scheduler`(`ID_Sale`, `ID_Plane`, `DateCreated`, `Starts`, `Ends`) VALUES (?,?,?,?,?)");
            ps.setInt(1,schedu.getId_sale());
            ps.setInt(2,schedu.getId_plane());
            ps.setString(3,schedu.getDateCreated());
            ps.setDouble(4,schedu.getStarts());
            ps.setDouble(5,schedu.getEnds());
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
public int UpdateScheduler(scheduler schedu) throws SQLException, ClassNotFoundException{
    Connection conn = getConnection();
    try{
        PreparedStatement ps = conn.prepareStatement("UPDATE `scheduler` SET `ID_Sale`=?,`Starts`=?,`Ends`=? WHERE ID_Plane=? AND DateCreated =?");
        ps.setInt(1,schedu.getId_sale());
        ps.setDouble(2,schedu.getStarts());
        ps.setDouble(3,schedu.getEnds());
        ps.setInt(4,schedu.getId_plane());
        ps.setString(5,schedu.getDateCreated());

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

public int DeleteScheduler(int id) throws SQLException, ClassNotFoundException{
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM `scheduler` WHERE ID_Scheduler=?");
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
}


