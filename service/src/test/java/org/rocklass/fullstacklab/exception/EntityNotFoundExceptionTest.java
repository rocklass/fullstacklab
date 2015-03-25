package org.rocklass.fullstacklab.exception;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class EntityNotFoundExceptionTest {
    @Test
    public void canThrowEntityNotFoundException() {
        final String entityName = RandomStringUtils.random(RandomUtils.nextInt(0, 63));
        final Long id = RandomUtils.nextLong(0, Long.MAX_VALUE);
        try {
            throw new EntityNotFoundException(entityName, id);
        } catch (EntityNotFoundException e) {
            assertThat(e.getMessage(), equalTo("No " + entityName + " with id " + id));
            assertThat(e.getEntityName(), sameInstance(entityName));
            assertThat(e.getId(), sameInstance(id));
        }
    }
}
