package connectDB;
import org.apache.thrift.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static connectDB.jdbc.createConnection.getConnection;

public class JavaClient {
    public static void main(String[] args){
        try {
            TTransport  transport;
            transport = new TSocket("localhost",9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            connectDB.connectDBService.Client client = new connectDB.connectDBService.Client(protocol);
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
