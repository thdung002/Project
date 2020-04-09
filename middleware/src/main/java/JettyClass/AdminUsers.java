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

public class AdminUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("GET ALL USER ");
        try {
            resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            resp.addHeader("Access-Control-Allow-Credentials","true");
//            HttpSession session=req.getSession(false);
            TTransport transport; //1
            transport = new TSocket("localhost", 9090); //2
            transport.open(); //3
            TProtocol protocol = new TBinaryProtocol(transport); //4
            connectDBService.Client client = new connectDBService.Client(protocol); //5 Must have in client
            List<users> lstusr = client.GetAllUser();
            resp.setContentType("application/json;charset=UTF-8");
            ServletOutputStream out = resp.getOutputStream();
            Gson gson = new GsonBuilder().create();
            JsonArray arr = gson.toJsonTree(lstusr).getAsJsonArray();
            out.print(arr.toString());
//            if(session == null)
//            {
//                Cookie user = new Cookie("CurrentAccountID",String.valueOf(0));
//                Cookie type = new Cookie("CurrentAccountType",String.valueOf(0));
//                resp.addCookie(user);
//                resp.addCookie(type);
//
//            }
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        users usr = new users();
        usr.setFullname(req.getParameter("fullname"));
        usr.setUsername(req.getParameter("username"));
        usr.setPassword(req.getParameter("password"));
        usr.setAccountType(Integer.parseInt(req.getParameter("accounttype")));
        System.out.println("Add user");
        try {
            resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            resp.addHeader("Access-Control-Allow-Credentials","true");

            resp.setContentType("application/json;charset=UTF-8");
            HttpSession session=req.getSession(false);
            if(session != null ) {
                TTransport transport; //1
                transport = new TSocket("localhost",9090); //2
                transport.open(); //3
                TProtocol protocol = new TBinaryProtocol(transport); //4
                connectDBService.Client client = new connectDBService.Client(protocol); //5 Must have in client
                int result = client.InsertUser(usr);
                ServletOutputStream out = resp.getOutputStream();
                Gson gson = new GsonBuilder().create();
                Map<String, Integer> res= new HashMap<>();
                res.put("result",result);
                JsonObject arr = gson.toJsonTree(res).getAsJsonObject();
                out.print(arr.toString());
                transport.close();
            }
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }


}
