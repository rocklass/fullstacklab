package org.rocklass.fullstacklab.service;

import java.util.List;

import org.rocklass.fullstacklab.exception.EntityNotFoundException;

/**
 * Generic service for entities
 * 
 * @author rocklass
 *
 * @param <E>
 *            Entity
 */
public interface GenericService<E> {
    /**
     * Add entity
     * 
     * @param entity
     *            entity to add
     * @return added entity
     */
    E add(E entity);

    /**
     * Delete entity
     * 
     * @param id
     *            id of entity to delete
     * @throws EntityNotFoundException
     *             when entity with given id does not exist
     */
    void delete(Long id) throws EntityNotFoundException;

    /**
     * Find all entities
     * 
     * @return found entities
     */
    List<E> findAll();

    /**
     * Find entity with given id
     * 
     * @param id
     *            id of entity to find
     * @return entity corresponding to the given id
     * @throws EntityNotFoundException
     *             when entity with given id does not exist
     */
    E findById(Long id) throws EntityNotFoundException;

    /**
     * Update entity
     * 
     * @param entity
     *            entity to update
     * @return updated entity
     * @throws EntityNotFoundException
     *             when entity with given id does not exist
     */
    E update(E entity) throws EntityNotFoundException;
}
