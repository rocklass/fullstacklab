package org.rocklass.fullstacklab.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import java.io.StringWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	private MockMvc mvc;

    @Mock
    private ItemService itemServiceMock;

    @Before
    public void setUp() {
    	Mockito.reset(itemServiceMock);
    	ItemController itemController = new ItemController();
    	itemController.setService(itemServiceMock);
        mvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }
    
    @Test
	public void findItems() throws Exception {
		when(itemServiceMock.findAll()).thenReturn(new ArrayList<Item>());
		
		MockHttpServletRequestBuilder getRequest = get("/items");
		getRequest.accept(MediaType.APPLICATION_JSON);
		ResultActions resultAction = mvc.perform(getRequest);
		resultAction.andExpect(status().isOk());		
		
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
}
