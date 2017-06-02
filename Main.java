
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sergey on 29-May-17.
 */
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/mysql";
        String name = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected");
            System.out.println(con.getSchema());
            con.close();
            System.out.println("Disconnected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
