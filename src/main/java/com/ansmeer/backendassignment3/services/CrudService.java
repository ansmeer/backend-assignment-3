package com.ansmeer.backendassignment3.services;

import java.util.List;

/**
 * Interface to describe generic CRUD operations performed by services.
 *
 * @param <T>  generic entity type to be specified by the implementation
 * @param <ID> generic entity id type to be specified by the implementation
 */
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
     * @return the entities
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
}
