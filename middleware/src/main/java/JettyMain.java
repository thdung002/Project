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
    handler.addServlet(UserGetPlane.class,"/user/plane");
    handler.addServlet(SaleGetPlane.class,"/sale/plane");
    handler.addServlet(UserGetAllScheduler.class,"/user/scheduler");
    handler.addServlet(UserLogin.class,"/login");
    handler.addServlet(SaleGetBookingByID.class,"/sale/booking");
    handler.addServlet(UserAddBooking.class,"/user/booking/add");
    handler.addServlet(SaleGetSchedulerByID.class,"/sale/scheduler");
    handler.addServlet(UserLogout.class,"/logout");
    handler.addServlet(CheckingCookie.class,"/checkingcookie");
    handler.addServlet(DeleteScheduler.class,"/sale/schedule/delete");

    handler.addServlet(DeletePlane.class,"/admin/plane/delete");
    handler.addServlet(DeleteBooking.class,"/admin/booking/delete");
    handler.addServlet(DeleteUser.class,"/admin/user/delete");
    handler.addServlet(AdminBooking.class,"/admin/booking");
    handler.addServlet(AdminPlane.class,"/admin/plane");
    handler.addServlet(AdminUsers.class,"/admin/users");

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
