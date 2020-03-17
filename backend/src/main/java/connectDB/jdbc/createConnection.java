package connectDB.jdbc;
import java.sql.*;

public class createConnection {
    private static String DB_URL="jdbc:mysql://localhost/housebooking?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(DB_URL, username, password);
    }
}
