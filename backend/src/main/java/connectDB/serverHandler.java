package connectDB;
import org.apache.thrift.TException;
import connectDB.*;
import connectDB.dao.*;
import java.sql.SQLException;

import java.sql.SQLException;
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
     SaleDAO sale = SaleDAO.getInstance();
     UserDAO usern =  UserDAO.getInstance();
     BookingDAO bk =  BookingDAO.getInstance();
     PlaneDAO pl =  PlaneDAO.getInstance();

    @Override

    public List<sale> getSale() throws TException, SQLException, ClassNotFoundException {

        return sale.getSalelist();
    }

    @Override
    public List<sale> getSalebyID(int id) throws TException, SQLException, ClassNotFoundException {
        return sale.getSalebyID(id);
    }

    @Override
    public users getUsers(String usr, String pwd) throws TException, SQLException, ClassNotFoundException {
        return usern.getUserLogin(usr,pwd);
    }

    @Override
    public List<booking> getBooking() throws TException, SQLException, ClassNotFoundException {
        return bk.getBooking();
    }

    @Override
    public List<plane> getPlane() throws TException, SQLException, ClassNotFoundException {
        return pl.getPlane();
    }

    @Override
    public int insertBooking(booking infor) throws TException, SQLException, ClassNotFoundException {
        if(bk.insertBooking(infor)==1) return 1;
        else
        return 0;
    }

    @Override
    public int insertSale(sale saleinfo) throws TException, SQLException, ClassNotFoundException {
        if(sale.insertSale(saleinfo)==1) return 1;
        else
            return 0;

    }

}
