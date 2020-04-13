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
import javax.servlet.http.*;
import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends HttpServlet{
    public static Map<String, Object> ck = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("GET SALE ");
        try {
            resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            resp.addHeader("Access-Control-Allow-Credentials","true");

            TTransport transport; //1
            transport = new TSocket("localhost", 9090); //2
            transport.open(); //3
            TProtocol protocol = new TBinaryProtocol(transport); //4
            connectDBService.Client client = new connectDBService.Client(protocol); //5 Must have in client
            List<users> lstusr = client.GetListSale();
            resp.setContentType("application/json;charset=UTF-8");
            ServletOutputStream out = resp.getOutputStream();
            Gson gson = new GsonBuilder().create();
            JsonArray arr = gson.toJsonTree(lstusr).getAsJsonArray();
            out.print(arr.toString());
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username= req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("Checking user login");
        try {
            resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            resp.addHeader("Access-Control-Allow-Credentials","true");

            resp.setContentType("application/json;charset=UTF-8");
            //old session invalidate
            HttpSession session = req.getSession();

//            if(session!=null){session.invalidate();}
//            //new session created
//            req.getSession(true);
            //transport to server back-end
            TTransport transport; //1
            transport = new TSocket("localhost",9090); //2
            transport.open(); //3
            TProtocol protocol = new TBinaryProtocol(transport); //4
            connectDBService.Client client = new connectDBService.Client(protocol); //5 Must have in client
            users lstuser = client.GetUsers(username,password);
            if(lstuser != null){
                session.setAttribute("CurrentAccountID",lstuser.getId_sale());
                session.setAttribute("CurrentAccountType",lstuser.getAccountType());
                session.setMaxInactiveInterval(1800);


                ck.put(session.getId(), lstuser);
                System.out.println(ck);

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
