import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sergey on 29-May-17.
 */
public class CreatingDatabase {
    //Так мы создаем базу данных:
    private final static String createDatabaseQuery = "CREATE DATABASE bookstore CHARACTER SET utf8 COLLATE utf8_general_ci";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost/mysql";
        try (Connection connection = DriverManager.getConnection(url, "root", "");
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(createDatabaseQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
