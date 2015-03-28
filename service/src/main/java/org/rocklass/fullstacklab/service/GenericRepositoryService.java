package org.rocklass.fullstacklab.service;

import java.util.List;

import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Generic repository service for entities
 * 
 * @author rocklass
 *
 * @param <E>
 *            Entity
 */
@Service
public abstract class GenericRepositoryService<E extends Entity> implements GenericService<E> {

    /**
     * Get JPA repository for entities
     * 
     * @return JPA repository
     */
    public abstract JpaRepository<E, Long> getRepository();

    /**
     * Set JPA repository for entities
     * 
     * @param repository
     *            JPA repository
     */
    public abstract void setRepository(JpaRepository<E, Long> repository);

    /**
     * Get entity name
     * 
     * @return entity name
     */
    protected abstract String getEntityName();

    /**
     * Add entity in repository
     * 
     * @param entity
     *            entity to add
     * @return added entity
     */
    @Override
    public E add(final E entity) {
        return getRepository().saveAndFlush(entity);
    }

    /**
     * Delete entity from repository
     * 
     * @param id
     *            id of entity to delete
     * @throws EntityNotFoundException
     *             when entity with given id does not exist
     */
    @Override
    public void delete(final Long id) throws EntityNotFoundException {
        final E deletedEntity = findById(id);
        getRepository().delete(deletedEntity);
    }

    /**
     * Find all entities in repository
     * 
     * @return found entities
     */
    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    /**
     * Find entity with given id in repository
     * 
     * @param id
     *            id of entity to find
     * @return entity corresponding to the given id
     * @throws EntityNotFoundException
     *             when entity with given id does not exist
     */
    @Override
    public E findById(final Long id) throws EntityNotFoundException {
        final E found = getRepository().findOne(id);

        if (found == null) {
            throw new EntityNotFoundException(getEntityName(), id);
        }

        return found;
    }

    /**
     * Update entity in repository
     * 
     * @param entity
     *            entity to update
     * @return updated entity
     * @throws EntityNotFoundException
     *             when entity with given id does not exist
     */
    @Override
    public E update(final E entity) throws EntityNotFoundException {
        final E found = getRepository().findOne(entity.getId());

        if (found == null) {
            throw new EntityNotFoundException(getEntityName(), entity.getId());
        }

        return getRepository().saveAndFlush(entity);
    }
}
