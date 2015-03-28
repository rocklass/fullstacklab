package org.rocklass.fullstacklab.test.tools;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.rocklass.fullstacklab.model.Item;

/**
 * Factory to create random objects
 * 
 * @author rocklass
 *
 */
public final class RandomFactory {
    /**
     * Random number generator
     */
    private static final Random RANDOM = new Random();

    /**
     * Private constructor of static class {@link RandomFactory}
     */
    private RandomFactory() {
    }

    /**
     * Create random item
     * 
     * @return random item
     */
    public static Item createItem() {
        final Item item = new Item();
        item.setId(RandomUtils.nextLong(0, Long.MAX_VALUE));
        item.setChecked(RANDOM.nextBoolean());
        item.setDescription(RandomStringUtils.random(RandomUtils.nextInt(0, 63)));
        return item;
    }
}
