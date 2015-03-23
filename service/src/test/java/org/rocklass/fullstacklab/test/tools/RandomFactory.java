package org.rocklass.fullstacklab.test.tools;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.rocklass.fullstacklab.model.Item;

public class RandomFactory {
    private static Random random = new Random();

    public static Item createItem() {
        Item item = new Item();
        item.setId(RandomUtils.nextLong(0, Long.MAX_VALUE));
        item.setChecked(random.nextBoolean());
        item.setDescription(RandomStringUtils.random(RandomUtils.nextInt(0, 63)));
        return item;
    }
}
