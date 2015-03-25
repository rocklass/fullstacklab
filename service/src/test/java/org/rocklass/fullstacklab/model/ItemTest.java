package org.rocklass.fullstacklab.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class ItemTest {

    @Test
    public void canGetId() throws Exception {
        final Long id = RandomUtils.nextLong(0, Long.MAX_VALUE);
        final Item item = new Item();
        item.setId(id);

        assertThat(item.getId(), sameInstance(id));
    }

    @Test
    public void canGetChecked() throws Exception {
        final boolean checked = new Random().nextBoolean();
        final Item item = new Item();
        item.setChecked(checked);

        assertThat(item.isChecked(), equalTo(checked));
    }

    @Test
    public void canGetDescription() throws Exception {
        final String description = RandomStringUtils.random(RandomUtils.nextInt(0, 63));
        final Item item = new Item();
        item.setDescription(description);

        assertThat(item.getDescription(), sameInstance(description));
    }
}
