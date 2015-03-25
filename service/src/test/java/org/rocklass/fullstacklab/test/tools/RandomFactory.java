package org.rocklass.fullstacklab.test.tools;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.rocklass.fullstacklab.model.Item;

public final class RandomFactory {
    private static final Random RANDOM = new Random();
    
    private RandomFactory() {
    }

    public static Item createItem() {
        final Item item = new Item();
        item.setId(RandomUtils.nextLong(0, Long.MAX_VALUE));
        item.setChecked(RANDOM.nextBoolean());
        item.setDescription(RandomStringUtils.random(RandomUtils.nextInt(0, 63)));
        return item;
    }
}
