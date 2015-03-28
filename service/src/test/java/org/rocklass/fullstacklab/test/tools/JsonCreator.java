package org.rocklass.fullstacklab.test.tools;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;

import org.rocklass.fullstacklab.model.Item;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * Class to create JSON string from Object or Collections
 * 
 * @author rocklass
 *
 */
public final class JsonCreator {

    /**
     * Private constructor of static class {@link JsonCreator}
     */
    private JsonCreator() {
    }

    /**
     * Create JSON string from {@link Item}
     * 
     * @param item
     *            item to transform in JSON string
     * @return item as JSON string
     */
    public static String marshall(final Item item) {
        final StringWriter jsonWriter = new StringWriter();

        try {
            final JsonGenerator generator = new JsonFactory().createGenerator(jsonWriter);
            writeItem(generator, item);
            generator.close();
        } catch (IOException e) {
            // TODO error log
            e.printStackTrace();
        }

        return jsonWriter.toString();
    }

    /**
     * Create JSON string from {@link Collection}<{@link Item}>
     * 
     * @param item
     *            item to transform in JSON string
     * @return item as JSON string
     */
    public static String marshall(final Collection<Item> items) {
        final StringWriter jsonWriter = new StringWriter();

        try {
            final JsonGenerator generator = new JsonFactory().createGenerator(jsonWriter);
            generator.writeStartArray();
            for (final Item item : items) {
                writeItem(generator, item);
            }
            generator.writeEndArray();
            generator.close();
        } catch (IOException e) {
            // TODO error log
            e.printStackTrace();
        }

        return jsonWriter.toString();
    }

    /**
     * Write item in given {@link JsonGenerator}
     * 
     * @param generator
     *            JSON generator
     * @param item
     *            item to write
     * @throws IOException
     *             when writing in JSON generator
     */
    private static void writeItem(final JsonGenerator generator, final Item item) throws IOException {
        generator.writeStartObject();
        generator.writeBooleanField("checked", item.isChecked());
        generator.writeStringField("description", item.getDescription());
        generator.writeEndObject();
    }
}
