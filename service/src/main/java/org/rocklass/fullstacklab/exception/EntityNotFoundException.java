package org.rocklass.fullstacklab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an entity is not found
 * 
 * @author rocklass
 *
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "No such entity")
public class EntityNotFoundException extends Exception {

    /**
     * Exception UID
     */
    private static final long serialVersionUID = -5116916897789230712L;

    /**
     * Entity name
     */
    private final String entityName;

    /**
     * Entity id
     */
    private final Long id;

    /**
     * EntityNotFoundException constructor
     * 
     * @param entityName
     *            entity name
     * @param id
     *            entity id
     */
    public EntityNotFoundException(final String entityName, final Long id) {
        super("No " + entityName + " with id " + id);
        this.entityName = entityName;
        this.id = id;
    }

    /**
     * Get entity name
     * 
     * @return entity name
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Get entity id
     * 
     * @return entity id
     */
    public Long getId() {
        return id;
    }
}
