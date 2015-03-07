package org.rocklass.fullstacklab.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MockServletContext.class, TestContext.class})
@WebAppConfiguration
public class ItemControllerTest {
	
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new ItemController()).build();
	}

	@Test
	public void findItems() throws Exception {
		MockHttpServletRequestBuilder getRequest = get("/items");
		getRequest.accept(MediaType.APPLICATION_JSON);
//		ResultActions resultAction = mvc.perform(getRequest);
//		resultAction.andExpect(status().isOk());
		
		
//		assertThat(mvc.perform(get("/items").accept(MediaType.APPLICATION_JSON)), nullValue());
//		mvc.perform(get("/items")
//		.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
		// TODO complete
	}
	
	@Test
	public void addItem() throws Exception {
		StringWriter jsonWriter = new StringWriter();
		JsonGenerator generator = new JsonFactory().createGenerator(jsonWriter);
		generator.writeStartObject();
		generator.writeBooleanField("checked", false);
		generator.writeStringField("description", "My first task");
		generator.writeEndObject();
		
		mvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON).content(jsonWriter.toString()));
		
		// TODO complete
	}
	
	// TODO test other methods
}
