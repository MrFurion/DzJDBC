package DAO;

import java.util.List;

public interface DefaultDAO<T, I>{
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
    T getById(I id);
}
