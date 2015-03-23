package org.rocklass.fullstacklab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "No such entity")
public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = -5116916897789230712L;

    private final String entityName;

    private final Long id;

    public EntityNotFoundException(String entityName, Long id) {
        super("No " + entityName + " with id " + id);
        this.entityName = entityName;
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public Long getId() {
        return id;
    }
}
