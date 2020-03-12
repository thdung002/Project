import connectDB.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import JettyClass.*;
import javax.servlet.ServletContext;

public class JettyMain {
    int id=0;
public static void main(String[] args) throws Exception{

    Server server = new Server(8000);
    ServletContextHandler handler = new ServletContextHandler(server,"/");

    handler.addServlet(Planing.class,"/admin/plane");
    handler.addServlet(Sale.class,"/sale");
    handler.addServlet(User.class,"/login");
    handler.addServlet(Booking.class,"/admin/booking");
    handler.addServlet(AddBooking.class,"/booking/add");
    handler.addServlet(SaleByID.class,"/admin/sale");

    server.start();
    server.join();
}
}
