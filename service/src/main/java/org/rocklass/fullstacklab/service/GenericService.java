package org.rocklass.fullstacklab.service;

import java.util.List;

import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Item;

public interface GenericService<Entity> {
	Entity add(Entity added);

    void delete(Long id) throws EntityNotFoundException;

    List<Entity> findAll();

    Entity findById(Long id) throws EntityNotFoundException;

    Entity update(Item updated) throws EntityNotFoundException;
}
