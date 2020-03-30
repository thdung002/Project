package connectDB;
import org.apache.thrift.*;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class JavaServer {
    public static connectDB.serverHandler handler;
    public static connectDB.connectDBService.Processor processor;
    public static void main(String[] args){
        try {
            handler = new serverHandler();
            processor = new connectDBService.Processor(handler);
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the server listen to port 9090...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
