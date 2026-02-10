package com.atads.repository.interfaces;

import java.util.List;

public interface CrudRepository<T> {
    T create(T entity);
    List<T> findAll();
    T findById(int id);
    T update(int id, T entity);
    void delete(int id);
}
