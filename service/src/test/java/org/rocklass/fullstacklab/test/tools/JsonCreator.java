package org.rocklass.fullstacklab.test.tools;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;

import org.rocklass.fullstacklab.model.Item;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class JsonCreator {
	public static String marshall(Item item) {
		StringWriter jsonWriter = new StringWriter();

		try {
			JsonGenerator generator = new JsonFactory()
					.createGenerator(jsonWriter);
			writeItem(generator, item);
			generator.close();
		} catch (IOException e) {
			// TODO error log
			e.printStackTrace();
		}

		return jsonWriter.toString();
	}

	public static String marshall(Collection<Item> items) {
		StringWriter jsonWriter = new StringWriter();

		try {
			JsonGenerator generator = new JsonFactory()
					.createGenerator(jsonWriter);
			generator.writeStartArray();
			for (Item item : items) {
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

	private static void writeItem(JsonGenerator generator, Item item)
			throws IOException {
		generator.writeStartObject();
		generator.writeBooleanField("checked", item.isChecked());
		generator.writeStringField("description", item.getDescription());
		generator.writeEndObject();
	}
}
