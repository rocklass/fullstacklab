package org.rocklass.fullstacklab.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * Test of class {@link Item}
 * 
 * @author rocklass
 *
 */
public class ItemTest {

    /**
     * Test method {@link Item#setId(Long)} and {@link Item#getId()}
     */
    @Test
    public void canSetAndGetId() {
        final Long id = RandomUtils.nextLong(0, Long.MAX_VALUE);
        final Item item = new Item();
        item.setId(id);

        assertThat(item.getId(), sameInstance(id));
    }

    /**
     * Test method {@link Item#setChecked(boolean)} and {@link Item#isChecked()}
     */
    @Test
    public void canSetAndGetChecked() {
        final boolean checked = new Random().nextBoolean();
        final Item item = new Item();
        item.setChecked(checked);

        assertThat(item.isChecked(), equalTo(checked));
    }

    /**
     * Test method {@link Item#setDescription(String)} and
     * {@link Item#getDescription()}
     */
    @Test
    public void canSetAndGetDescription() {
        final String description = RandomStringUtils.random(RandomUtils.nextInt(0, 63));
        final Item item = new Item();
        item.setDescription(description);

        assertThat(item.getDescription(), sameInstance(description));
    }
}
