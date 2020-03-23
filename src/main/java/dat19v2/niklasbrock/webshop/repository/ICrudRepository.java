package dat19v2.niklasbrock.webshop.repository;

import java.util.List;

public interface ICrudRepository<T> {
    void create(T t);
    List<T> findAll();
    T read(int id);
    boolean update(T t);
    boolean delete(int id);
}
