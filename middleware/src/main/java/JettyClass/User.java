package JettyClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import connectDB.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class User  extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username= req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("Checking user login");
        try {
            resp.addHeader("Access-Control-Allow-Origin", "*");
            resp.addHeader("Access-Control-Allow-Methods", "POST, GET");
            resp.setContentType("application/json;charset=UTF-8");

            TTransport transport; //1
            transport = new TSocket("localhost",9090); //2
            transport.open(); //3
            TProtocol protocol = new TBinaryProtocol(transport); //4
            connectDBService.Client client = new connectDBService.Client(protocol); //5 Must have in client
            users lstuser = client.getUsers(username,password);
            if(lstuser != null){
                ServletOutputStream out = resp.getOutputStream();
                Gson gson = new GsonBuilder().create();
                JsonObject arr = gson.toJsonTree(lstuser).getAsJsonObject();
                out.print(arr.toString());
            }
            else{
                resp.setStatus(404);
                req.setAttribute("error", "Unknown user, please try again");
            }
            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
