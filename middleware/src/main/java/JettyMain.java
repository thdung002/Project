import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import JettyClass.*;

public class JettyMain {
    int id=0;
public static void main(String[] args) throws Exception{
    Server server = new Server(8000);
    ServletContextHandler handler = new ServletContextHandler(server,"/");
    handler.addServlet(PlaneForUser.class,"/plane");
    handler.addServlet(Planing.class,"/admin/plane");
    handler.addServlet(Scheduler.class,"/sale");
    handler.addServlet(User.class,"/login");
    handler.addServlet(Booking.class,"/admin/booking");
    handler.addServlet(AddBooking.class,"/booking/add");
    handler.addServlet(SchedulerByID.class,"/admin/sale");
    handler.addServlet(Logout.class,"/logout");
    //specify session ID manager
    HashSessionIdManager idmanager = new HashSessionIdManager();
    server.setSessionIdManager(idmanager);

    //
    HashSessionManager manager = new HashSessionManager();
    SessionHandler sessions = new SessionHandler(manager);
    handler.setHandler(sessions);


    server.start();
    server.join();
}
}
