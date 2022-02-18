package ua.com.alevel.service;

import ua.com.alevel.db.CustomList;


public interface BaseService<E> {
    void create(E e);

    void update(E e) throws Exception;

    void delete(String id) throws Exception;

    E findById(String id) throws Exception;

    CustomList<E> findAll();
}
