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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleGetSchedulerByID extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" GET Scheduler by ID");
        try {
            resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            resp.addHeader("Access-Control-Allow-Credentials","true");
            HttpSession session=req.getSession(false);
            if(session != null ){
                TTransport transport; //1
                transport = new TSocket("localhost",9090); //2
                transport.open(); //3
                TProtocol protocol = new TBinaryProtocol(transport); //4
                int id = Integer.parseInt(req.getParameter("id"));
                connectDBService.Client client = new connectDBService.Client(protocol); //5 Must have in client

                List<scheduler> lstsale = client.GetSchedulerById(id);
                resp.setContentType("application/json;charset=UTF-8");
                ServletOutputStream out = resp.getOutputStream();
                Gson gson = new GsonBuilder().create();
                JsonArray arr = gson.toJsonTree(lstsale).getAsJsonArray();
                out.print(arr.toString());
                transport.close();

            }

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        scheduler sl = new scheduler();
        sl.setDateCreated(req.getParameter("date"));
        sl.setId_sale(Integer.parseInt(req.getParameter("id")));
        sl.setId_plane(Integer.parseInt(req.getParameter("idplane")));
        sl.setStarts(Float.parseFloat(req.getParameter("start")));
        sl.setEnds(Float.parseFloat(req.getParameter("end")));
        System.out.println("Add sale");
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
                int result = client.InsertOrUpdateScheduler(sl);
                if(result >= 1){
                    ServletOutputStream out = resp.getOutputStream();
                    Gson gson = new GsonBuilder().create();
                    Map<String, Integer> res= new HashMap<>();
                    res.put("result",result);
                    JsonObject arr = gson.toJsonTree(res).getAsJsonObject();
                    out.print(arr.toString());
                }
                else{
                    resp.setStatus(404);
                    req.setAttribute("error", "Cant add");
                }
                transport.close();
            }
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }

}
