package com.ansmeer.backendassignment3.services;

import java.util.Collection;

public interface CrudService<T, ID> {
    T findById(ID id);

    Collection<T> findAll();

    T add(T entity);

    T update(T entity);

    int deleteById(ID id);

    int delete(T entity);

}
