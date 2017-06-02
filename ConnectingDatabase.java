import java.sql.*;

/**
 * Created by Sergey on 29-May-17.
 */
public class ConnectingDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/chinook";
        String name = "root";
        String password = "";

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT title FROM album");
            printResults(rs);
            connection.close();
            System.out.println("Disconnected");
        } catch (SQLException e) {
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

    private static void printResults(ResultSet rs) throws SQLException {
        String title;
        System.out.println("******************************");
        while (rs.next()) {
            title = rs.getString("title");
            System.out.println("Title: " + title);
        }
        System.out.println("******************************");
    }
}
