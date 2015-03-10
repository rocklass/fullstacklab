package org.rocklass.fullstacklab.controller;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.service.ItemService;
import org.rocklass.fullstacklab.test.JsonCreator;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	private MockMvc mvc;

    @Mock
    private ItemService itemServiceMock;
    
    @InjectMocks
    private ItemController itemController;

    @Before
    public void setUp() {
    	Mockito.reset(itemServiceMock);
    	itemController.setService(itemServiceMock);
        mvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }
    
    @Test
    public void getService() {
    	assertThat(itemController.getService(), sameInstance(itemServiceMock));
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
		ResultActions resultAction = mvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON).content(JsonCreator.getRandomItem()));
		resultAction.andExpect(status().isOk());
		// TODO complete
	}
    
    @Test
	public void updateItem() throws Exception {
    	when(itemServiceMock.update(any(Item.class))).thenReturn(new Item());
    	
		ResultActions resultAction = mvc.perform(put("/items/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON).content(JsonCreator.getRandomItem()));
		resultAction.andExpect(status().isOk());
		
		// TODO complete
    }
    
    @Test
	public void updateItemUnprocessableEntity() throws Exception {
    	when(itemServiceMock.update(any(Item.class))).thenThrow(new EntityNotFoundException("item", 2L));
    	
		ResultActions resultAction = mvc.perform(put("/items/{id}", 2L)
                .contentType(MediaType.APPLICATION_JSON).content(JsonCreator.getRandomItem()));
		resultAction.andExpect(status().isUnprocessableEntity());
		
		// TODO complete
    }
    
    @Test
	public void deleteItem() throws Exception {
    	ResultActions resultAction = mvc.perform(delete("/items/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON).content(JsonCreator.getRandomItem()));
		resultAction.andExpect(status().isOk());
		
		// TODO complete
    }
    
    @Test
	public void deleteItemUnprocessableEntity() throws Exception {
    	doThrow(new EntityNotFoundException("item", 2L)).when(itemServiceMock).delete(anyLong());
    	
    	ResultActions resultAction = mvc.perform(delete("/items/{id}", 2L)
                .contentType(MediaType.APPLICATION_JSON).content(JsonCreator.getRandomItem()));
    	resultAction.andExpect(status().isUnprocessableEntity());
    	
    	// TODO complete
    }
}
