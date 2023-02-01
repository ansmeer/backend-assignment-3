package com.ansmeer.backendassignment3.services;

import java.util.List;

public interface CrudService<T, ID> {
    /**
     * Returns an entity of type T from the repository by its ID.
     *
     * @param id the id to look for
     * @return the entity
     */
    T findById(ID id);

    /**
     * Returns a list with all entities of type T from the repository.
     *
     * @return the entitites
     */
    List<T> findAll();

    /**
     * Saves a new entity of type T in the repository.
     *
     * @param entity the entity to add
     * @return the added entity
     */
    T add(T entity);

    /**
     * Updates the entity of type T in the repository.
     *
     * @param entity the entity to update
     */
    void update(T entity);

    /**
     * Deletes an entity by its ID from the repository.
     *
     * @param id the ID of the entity to delete
     */
    void deleteById(ID id);

    /**
     * Deletes an entity from the repository.
     *
     * @param entity the entity to delete
     */
    void delete(T entity);
}
