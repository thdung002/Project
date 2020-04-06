package connectDB;
import org.apache.thrift.TException;
import connectDB.*;
import connectDB.dao.*;
import java.sql.SQLException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class serverHandler implements connectDBService.Iface{
    SchedulerDAO schedu = SchedulerDAO.getInstance();
    UserDAO usern =  UserDAO.getInstance();
    BookingDAO bk =  BookingDAO.getInstance();
    PlaneDAO pl =  PlaneDAO.getInstance();

    @Override

    public List<scheduler> GetScheduler() throws TException, SQLException, ClassNotFoundException {

        return schedu.GetScheduler();
    }

    @Override
    public List<scheduler> GetSchedulerById(int id) throws TException, SQLException, ClassNotFoundException {
        return schedu.GetSchedulerByID(id);
    }

    @Override
    public users GetUsers(String usr, String pwd) throws TException, SQLException, ClassNotFoundException {
        return usern.getUserLogin(usr,pwd);
    }

    @Override
    public List<booking> GetBooking() throws TException, SQLException, ClassNotFoundException {
        return bk.GetBooking();
    }

    @Override
    public List<booking> GetBookingById(int id) throws TException, SQLException, ClassNotFoundException {
        return bk.GetBookingById(id);
    }

    @Override
    public List<plane> GetPlaneForUser() throws TException, SQLException, ClassNotFoundException {
        return pl.GetPlane();
    }

    @Override
    public List<plane> GetPlane(int id) throws TException, SQLException, ClassNotFoundException {
        return pl.GetPlane(id);
    }

    @Override
    public int InsertBooking(booking infor) throws TException, SQLException, ClassNotFoundException {
        if(bk.InsertBooking(infor)==1) return 1;
        else
            return 0;
    }

    @Override
    public int InsertScheduler(scheduler sc) throws TException, SQLException, ClassNotFoundException {
        if(schedu.InsertScheduler(sc)==1) return 1;
        else
            return 0;
    }

    @Override
    public int InsertPlane(plane planes) throws TException, SQLException, ClassNotFoundException {
        if(pl.InsertPlane(planes)== 1) return 1;
        else
            return 0;
    }

    @Override
    public int UpdateScheduler(scheduler schedul) throws TException, SQLException, ClassNotFoundException {
        if(schedu.UpdateScheduler(schedul)== 1) return 1;
        else
            return 0;

    }

    @Override
    public int UpdatePlane(int id_plane, int id_sale) throws TException, SQLException, ClassNotFoundException {
        if(pl.UpdatePlane(id_plane,id_sale)== 1) return 1;
        else
            return 0;

    }

    @Override
    public int InsertOrUpdateScheduler(scheduler schedul) throws TException, SQLException, ClassNotFoundException {
        List<scheduler> schedulDatabase = new ArrayList<>();
        schedulDatabase = schedu.GetSchedulerByID(schedul.getId_sale());
        int result=0;//0 is false, 1 is success
        int checking=0;
        for(scheduler scheduldata : schedulDatabase)
            if(scheduldata.getDateCreated().contains(schedul.getDateCreated()))
            {
                checking=1;
                break;
            }
        if(checking==0)//add new
        {
            InsertScheduler(schedul);
            result=7;
        }
        else {
            for (scheduler scheduldata : schedulDatabase) {
                if (scheduldata.getDateCreated().contains(schedul.getDateCreated())) {
                    if (scheduldata.getId_plane() == schedul.getId_plane()) {
                        if (schedul.getStarts() >= scheduldata.getStarts() && schedul.getStarts() <= scheduldata.getEnds() && schedul.getEnds() >= scheduldata.getEnds())// if new start time in [start,end]
                        {
                            schedul.setStarts(scheduldata.getStarts());
                            UpdateScheduler(schedul);
                            result = 2;
                            break;
                        }
                        if (schedul.getEnds() >= scheduldata.getStarts() && schedul.getEnds() <= scheduldata.getEnds() && schedul.getStarts() <= scheduldata.getStarts())// if new end in time [start,end]
                        {
                            schedul.setEnds(scheduldata.getEnds());
                            UpdateScheduler(schedul);
                            result = 3;
                            break;
                        }
                        if (schedul.getStarts() < scheduldata.getStarts() && schedul.getEnds() > scheduldata.getEnds()) // if both new time start, end is bigger than the old [start,end]
                        {
                            UpdateScheduler(schedul);
                            result = 4;
                            break;
                        }
                        if ((schedul.getStarts() < scheduldata.getStarts() && schedul.getEnds() < scheduldata.getStarts()) || (schedul.getStarts() > scheduldata.getEnds() && schedul.getEnds() > scheduldata.getEnds())) //if out of range insert new
                        {
                            InsertScheduler(schedul);
                            UpdatePlane(schedul.getId_plane(), schedul.getId_sale());
                            result = 5;
                            break;
                        }
                    }
                    if ((scheduldata.getId_plane() != schedul.getId_plane()) &&
                            ((schedul.getStarts() < scheduldata.getStarts() && schedul.getEnds() < scheduldata.getStarts())
                                    || (schedul.getStarts() > scheduldata.getEnds() && schedul.getEnds() > scheduldata.getEnds())))  //if out of range insert new
                    {
                        InsertScheduler(schedul);
                        UpdatePlane(schedul.getId_plane(), schedul.getId_sale());
                        result = 6;
                        break;
                    }

                }

            }
        }
        System.out.println("Result: "+ result);
        return result;
    }

    @Override
    public List<users> GetListSale() throws TException, SQLException, ClassNotFoundException {
        return usern.GetListSale();
    }

    @Override
    public List<users> GetAllUser() throws TException, SQLException, ClassNotFoundException {
        return usern.GetAllUser();
    }

    @Override
    public List<plane> GetAllPlane() throws TException, SQLException, ClassNotFoundException {
        return pl.GetPlane();
    }

}
