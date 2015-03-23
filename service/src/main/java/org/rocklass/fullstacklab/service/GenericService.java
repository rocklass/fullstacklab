package org.rocklass.fullstacklab.service;

import java.util.List;

import org.rocklass.fullstacklab.exception.EntityNotFoundException;

public interface GenericService<E> {
    E add(E added);

    void delete(Long id) throws EntityNotFoundException;

    List<E> findAll();

    E findById(Long id) throws EntityNotFoundException;

    E update(E updated) throws EntityNotFoundException;
}
