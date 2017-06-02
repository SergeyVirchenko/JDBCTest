import java.sql.*;

/**
 * Created by Sergey on 29-May-17.
 */
public class BookStore {

    private Connection con;

    public BookStore() {
        String url = "jdbc:mysql://localhost/bookstore?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
        String name = "root";
        String password = "";
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            String query = "INSERT INTO BOOKS ('author', 'title', 'comment', 'price') VALUES ('Name', 'NewTitle', 'Hello', 1)";
            ResultSet rs = st.executeQuery(query);
            printResults(rs);
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printResults(ResultSet rs) throws SQLException {
        String author, title, comment;
        double price;
        while (rs.next()) {
            author = rs.getString("author");
            title = rs.getString("title");
            comment = rs.getString("comment");
            price = rs.getDouble("price");
            System.out.println("******************************");
            System.out.println("Author: " + author);
            System.out.println("Title: " + title);
            System.out.println("Price: " + price);
            System.out.println("comment: " + comment);
            System.out.println("******************************");
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BookStore bookStore = new BookStore();
    }

}
