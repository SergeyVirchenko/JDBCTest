package dao;

import model.Album;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 02-Jun-17.
 */
public class AlbumDAO implements DAO<Album> {

    public String ID = "albumid";
    public String TITLE = "title";
    public String ARTIST_ID = "artistid";

    public static final String FIND_ALL = "SELECT * FROM album";

    @Override
    public List<Album> findAll() {
        List<Album> data = new ArrayList<>();
        try (Connection con = BDHelper.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(FIND_ALL);
            while (rs.next()) {
                data.add(new Album(
                        rs.getInt(ID),
                        rs.getString(TITLE),
                        rs.getInt(ARTIST_ID)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
