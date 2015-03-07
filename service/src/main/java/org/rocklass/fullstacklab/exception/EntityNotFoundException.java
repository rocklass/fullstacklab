package org.rocklass.fullstacklab.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = -5116916897789230712L;

	public EntityNotFoundException(String entityName, Long id) {
        super("No " + entityName + " with id " + id);
    }

}
