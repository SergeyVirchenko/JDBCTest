import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Sergey on 29-May-17.
 */
public class CreatingTable {
    private final static String createTableQuery = "CREATE TABLE `books` (" +
            " `id` int(11) NOT NULL auto_increment," +
            " `title` varchar(50) default NULL," +
            " `comment` varchar(100) default NULL," +
            " `price` double default NULL," +
            " `author` varchar(50) default NULL," +
            " PRIMARY KEY (`id`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Подключаемся к новосозданной базе. Значение параметров после "?"
            //ясно из их имен.
            String url = "jdbc:mysql://localhost/bookstore?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
            connection = DriverManager.getConnection(url, "root", "");
            statement = connection.createStatement();
            statement.executeUpdate(createTableQuery);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //позакрываем теперь все
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
