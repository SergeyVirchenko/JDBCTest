package model;

/**
 * Created by Sergey on 02-Jun-17.
 */
public class Album {

    public int id;
    public String title;
    public int artistId;

    public Album(int id, String title, int artistId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
    }
}
