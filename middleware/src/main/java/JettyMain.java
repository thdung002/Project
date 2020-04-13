import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import JettyClass.*;

public class JettyMain {
public static void main(String[] args) throws Exception{

    Server server = new Server(8000);
    ServletContextHandler handler = new ServletContextHandler(server,"/");
    handler.addServlet(UserPlane.class,"/user/plane");
    handler.addServlet(SalePlane.class,"/sale/plane");
    handler.addServlet(UserSchedule.class,"/user/scheduler");
    handler.addServlet(Login.class,"/login");
    handler.addServlet(SaleBooking.class,"/sale/booking");
    handler.addServlet(UserBooking.class,"/user/booking/add");
    handler.addServlet(SaleSchedule.class,"/sale/scheduler");
    handler.addServlet(Logout.class,"/logout");
    handler.addServlet(CheckingCookie.class,"/checkingcookie");

    handler.addServlet(AdminBooking.class,"/admin/booking");
    handler.addServlet(AdminPlane.class,"/admin/plane");
    handler.addServlet(AdminUsers.class,"/admin/users");
    handler.addServlet(AdminPlaneDelete.class,"/admin/plane/delete");
    handler.addServlet(AdminUserDelete.class,"/admin/users/delete");
    handler.addServlet(SaleScheduleDelete.class,"/sale/scheduler/delete");

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
