package org.rocklass.fullstacklab.test;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class JsonCreator {
	public static String getRandomItem() {
		StringWriter jsonWriter = new StringWriter();

		try {
			JsonGenerator generator = new JsonFactory()
					.createGenerator(jsonWriter);
			generator.writeStartObject();
			generator.writeBooleanField("checked", false);
			generator.writeStringField("description", "My first task");
			generator.writeEndObject();
			generator.close();
		} catch (IOException e) {
			// TODO error log
			e.printStackTrace();
		}

		return jsonWriter.toString();
	}
}
