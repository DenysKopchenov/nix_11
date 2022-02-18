package ua.com.alevel.dao;

import ua.com.alevel.db.CustomList;

import java.util.Optional;

public interface GenericDao<E> {
    void create(E e);

    void update(E e);

    void delete(String id);

    Optional<E> findById(String id);

    CustomList<E> findAll();
}
