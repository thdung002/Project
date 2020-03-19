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
    public List<plane> GetPlane() throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {

            List<plane> planelist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from plane ");
            while(rs.next()){
                plane pl=new plane();
                pl.setId_plane(Integer.parseInt(rs.getString("ID_Plane")));
                pl.setPlanename(rs.getString("Planename"));
                if(rs.getString("ID_Sale") == null ){
                    pl.setId_sale(0);
                }
                else{
                    pl.setId_sale(Integer.parseInt(rs.getString("ID_Sale")));}
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


    public List<plane> GetPlane(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = getConnection();
        try {

            List<plane> planelist = new ArrayList<>();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from plane where ID_sale IS NULL OR ID_sale ="+id);
            while(rs.next()){
                plane pl=new plane();
                pl.setId_plane(Integer.parseInt(rs.getString("ID_Plane")));
                pl.setPlanename(rs.getString("Planename"));
                if(rs.getString("ID_Sale") == null ){
                    pl.setId_sale(0);
                }
                else{
                pl.setId_sale(Integer.parseInt(rs.getString("ID_Sale")));}
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
public int InsertPlane(plane pl) throws SQLException,ClassNotFoundException{
    Connection conn = getConnection();
    try{
        PreparedStatement ps = conn.prepareStatement
                ("INSERT INTO `plane`(`Planename`)  VALUES (?)");
        ps.setString(1,pl.getPlanename());
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
public int UpdatePlane(int id_plane,int id_sale) throws SQLException, ClassNotFoundException{
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE `plane` SET `ID_Sale`=? WHERE ID_Plane=?");
            ps.setInt(1,id_sale);
            ps.setInt(2,id_plane);
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

