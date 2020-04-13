package JettyClass;

import javax.servlet.http.HttpServlet;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            resp.setContentType("application/json;charset=UTF-8");
            resp.addHeader("Access-Control-Allow-Credentials","true");

            HttpSession session = req.getSession(false);
            if(session!= null){
                session.removeAttribute("CurrentAccountID");
                session.invalidate();
                System.out.println("You are logged out");
            }
            Cookie user = new Cookie("CurrentAccountID", "0");
            Cookie type = new Cookie("CurrentAccountType", "0");
            user.setMaxAge(0);
            type.setMaxAge(0);
            resp.addCookie(type);
            resp.addCookie(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
