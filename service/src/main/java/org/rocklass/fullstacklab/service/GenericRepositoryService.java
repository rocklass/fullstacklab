package org.rocklass.fullstacklab.service;

import java.util.List;

import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericRepositoryService<Entity> implements GenericService<Entity> {
	
	public abstract JpaRepository<Entity, Long> getRepository();
	
	public abstract void setRepository(JpaRepository<Entity, Long> repository);
	
	protected abstract String getEntityName();

	public Entity add(Entity added) {
		return getRepository().saveAndFlush(added);
	}

	public void delete(Long id) throws EntityNotFoundException {
		Entity deleted = findById(id);
		getRepository().delete(deleted);
	}

	public List<Entity> findAll() {
		return getRepository().findAll();
	}

	public Entity findById(Long id) throws EntityNotFoundException {
		Entity found = getRepository().findOne(id);

        if (found == null) {
            throw new EntityNotFoundException(getEntityName(), id);
        }

        return found;
	}

	public Entity update(Entity updated) {
		return getRepository().saveAndFlush(updated);
	}

}
