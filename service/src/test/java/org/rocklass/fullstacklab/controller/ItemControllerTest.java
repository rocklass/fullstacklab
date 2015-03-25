package org.rocklass.fullstacklab.controller;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.rocklass.fullstacklab.exception.EntityNotFoundException;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.service.ItemService;
import org.rocklass.fullstacklab.test.tools.JsonCreator;
import org.rocklass.fullstacklab.test.tools.RandomFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ItemControllerTest extends ControllerTest {

    @Mock
    private transient ItemService itemServiceMock;

    @InjectMocks
    private transient ItemController itemController;
    
    @Override
    public String getUrl() {
        return "/items";
    }

    @Before
    public void setUp() {
        Mockito.reset(itemServiceMock);
        itemController.setService(itemServiceMock);
        setMvc(MockMvcBuilders.standaloneSetup(itemController).build());
    }

    @Test
    public void getService() {
        assertThat(itemController.getService(), sameInstance(itemServiceMock));
    }

    @Test
    public void findItems() throws Exception {
        // given
        final Item item = RandomFactory.createItem();
        final List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(item);
        when(itemServiceMock.findAll()).thenReturn(itemsList);

        // when
        final MockHttpServletRequestBuilder getRequest = get(getUrl());
        getRequest.accept(MediaType.APPLICATION_JSON);
        final ResultActions resultAction = getMvc().perform(getRequest);

        // then
        resultAction.andExpect(status().isOk());
        resultAction.andExpect(content().contentType(getContentType()));
        resultAction.andExpect(content().json(JsonCreator.marshall(itemsList)));
    }

    @Test
    public void findItemsEmpty() throws Exception {
        // given
        final List<Item> emptyItemsList = new ArrayList<Item>();
        when(itemServiceMock.findAll()).thenReturn(emptyItemsList);

        // when
        final MockHttpServletRequestBuilder getRequest = get(getUrl());
        getRequest.accept(MediaType.APPLICATION_JSON);
        final ResultActions resultAction = getMvc().perform(getRequest);

        // then
        resultAction.andExpect(status().isOk());
        resultAction.andExpect(content().contentType(getContentType()));
        resultAction.andExpect(content().json(JsonCreator.marshall(emptyItemsList)));
    }

    @Test
    public void addItem() throws Exception {
        // given
        final Item item1 = RandomFactory.createItem();
        final Item item2 = new Item();
        item2.setId(null);
        item2.setChecked(item1.isChecked());
        item2.setDescription(item1.getDescription());
        when(itemServiceMock.add(any(Item.class))).thenReturn(item1);

        // when
        final ResultActions resultAction = getMvc().perform(post(getUrl()).contentType(MediaType.APPLICATION_JSON).content(JsonCreator.marshall(item1)));

        // then
        resultAction.andExpect(status().isOk());
        resultAction.andExpect(content().contentType(getContentType()));
        resultAction.andExpect(content().json(JsonCreator.marshall(item1)));

        // assert id = null when calling service.add
        verify(itemServiceMock, times(1)).add(Matchers.refEq(item2));
    }

    @Test
    public void updateItem() throws Exception {
        // given
        final Item item1 = RandomFactory.createItem();
        final Item item2 = new Item();
        item2.setId(null);
        item2.setChecked(item1.isChecked());
        item2.setDescription(item1.getDescription());
        when(itemServiceMock.update(any(Item.class))).thenReturn(item1);

        // when
        final ResultActions resultAction = getMvc().perform(put(getUrl() + ControllerTest.URL_VARIABLE_ID, item1.getId()).contentType(MediaType.APPLICATION_JSON).content(JsonCreator.marshall(item2)));

        // then
        resultAction.andExpect(status().isOk());
        resultAction.andExpect(content().contentType(getContentType()));
        resultAction.andExpect(content().json(JsonCreator.marshall(item1)));

        // assert id = item1.id when calling service.update
        verify(itemServiceMock, times(1)).update(Matchers.refEq(item1));
    }

    @Test
    public void updateItemUnprocessableEntity() throws Exception {
        // given
        final Item item = RandomFactory.createItem();
        when(itemServiceMock.update(any(Item.class))).thenThrow(new EntityNotFoundException("item", item.getId()));

        // when
        final ResultActions resultAction = getMvc().perform(put(getUrl() + ControllerTest.URL_VARIABLE_ID, item.getId()).contentType(MediaType.APPLICATION_JSON).content(JsonCreator.marshall(item)));

        // then
        resultAction.andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void deleteItem() throws Exception {
        // given
        final Item item = RandomFactory.createItem();

        // when
        final ResultActions resultAction = getMvc().perform(delete(getUrl() + ControllerTest.URL_VARIABLE_ID, item.getId()).contentType(MediaType.APPLICATION_JSON).content(JsonCreator.marshall(item)));

        // then
        resultAction.andExpect(status().isOk());
        resultAction.andDo(MockMvcResultHandlers.print());

        // assert id = item.id when calling service.delete
        verify(itemServiceMock, times(1)).delete(Matchers.refEq(item.getId()));
    }

    @Test
    public void deleteItemUnprocessableEntity() throws Exception {
        // given
        final Item item = RandomFactory.createItem();
        doThrow(new EntityNotFoundException("item", item.getId())).when(itemServiceMock).delete(anyLong());

        // when
        final ResultActions resultAction = getMvc().perform(delete(getUrl() + ControllerTest.URL_VARIABLE_ID, item.getId()).contentType(MediaType.APPLICATION_JSON).content(JsonCreator.marshall(item)));

        // then
        resultAction.andExpect(status().isUnprocessableEntity());
    }
}
