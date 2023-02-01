package com.ansmeer.backendassignment3.services;

import java.util.List;

public interface CrudService<T, ID> {
    T findById(ID id);

    List<T> findAll();

    T add(T entity);

    void update(T entity);

    void deleteById(ID id);

    void delete(T entity);

}
