package dao;

import java.util.List;

/**
 * Created by Sergey on 02-Jun-17.
 */
public interface DAO<T> {
    public List<T> findAll();
}
