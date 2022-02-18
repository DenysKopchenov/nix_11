package ua.com.alevel.db;

public interface GenericDB<E> {
    void create(E e);

    void update(E e);

    void delete(String id);

    E findById(String id);

    CustomList<E> findAll();
}
