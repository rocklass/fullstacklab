package org.rocklass.fullstacklab.service;

import java.util.List;

import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericRepositoryService<E extends Entity> implements GenericService<E> {

    public abstract JpaRepository<E, Long> getRepository();

    public abstract void setRepository(JpaRepository<E, Long> repository);

    protected abstract String getEntityName();

    @Override
    public E add(E added) {
        return getRepository().saveAndFlush(added);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        E deleted = findById(id);
        getRepository().delete(deleted);
    }

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public E findById(Long id) throws EntityNotFoundException {
        E found = getRepository().findOne(id);

        if (found == null) {
            throw new EntityNotFoundException(getEntityName(), id);
        }

        return found;
    }

    @Override
    public E update(E updated) throws EntityNotFoundException {
        E found = getRepository().findOne(updated.getId());

        if (found == null) {
            throw new EntityNotFoundException(getEntityName(), updated.getId());
        }

        return getRepository().saveAndFlush(updated);
    }

}
