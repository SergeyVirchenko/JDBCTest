import dao.AlbumDAO;
import model.Album;

import java.util.List;

/**
 * Created by Sergey on 02-Jun-17.
 */
public class DAOTest {
    public static void main(String[] args) {
        List<Album> data = new AlbumDAO().findAll();
    }
}
