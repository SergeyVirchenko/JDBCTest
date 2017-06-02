package dao;

import java.sql.*;

/**
 * Created by Sergey on 02-Jun-17.
 */
public class BDHelper {
    private static final String URL = "jdbc:mysql://localhost/chinook";
    private static final String NAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, NAME, PASSWORD);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
