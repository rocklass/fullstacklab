package org.rocklass.fullstacklab.test.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.rocklass.fullstacklab.controller.ControllerTest;
import org.rocklass.fullstacklab.controller.ItemController;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.test.tools.RandomFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

/**
 * Integration test of {@link ItemController}
 * 
 * @author rocklass
 *
 */
public class ItemControllerIT extends ServiceIntegrationTest {
    /**
     * Get request mapping for item controller
     * 
     * @return /items
     */
    @Override
    public String getRequestMapping() {
        return "/items";
    }

    /**
     * Test GET method of {@link ItemController}
     */
    @Test
    public void findItems() {
        // when
        final List<Item> items = new ArrayList<Item>();
        @SuppressWarnings("unchecked")
        final ResponseEntity<List<Item>> response = (ResponseEntity<List<Item>>) getTemplate().getForEntity(getBase().toString(), items.getClass());

        // then
        assertThat(response.getBody(), instanceOf(items.getClass()));
    }

    /**
     * Test POST method of {@link ItemController}
     */
    @Test
    public void addItem() {
        // given
        final Item item = RandomFactory.createItem();

        // when
        final ResponseEntity<Item> response = getTemplate().postForEntity(getBase().toString(), item, Item.class);

        // then
        assertThat(response.getBody().isChecked(), equalTo(item.isChecked()));
        assertThat(response.getBody().getDescription(), equalTo(item.getDescription()));
    }

    /**
     * Test PUT method of {@link ItemController}
     */
    @Test
    public void updateItem() {
        final Item item = RandomFactory.createItem();
        final Map<String, String> urlVariables = new ConcurrentHashMap<String, String>();
        urlVariables.put("id", item.getId().toString());

        try {
            getTemplate().put(getBase().toString() + ControllerTest.URL_VARIABLE_ID, item, urlVariables);
        } catch (RestClientException e) {
            fail("Cannot put item");
        }
    }

    /**
     * Test DELETE method of {@link ItemController}
     */
    @Test
    public void deleteItem() {
        final Item item = RandomFactory.createItem();
        final Map<String, String> urlVariables = new ConcurrentHashMap<String, String>();
        urlVariables.put("id", item.getId().toString());
        try {
            getTemplate().delete(getBase().toString() + ControllerTest.URL_VARIABLE_ID, urlVariables);
        } catch (RestClientException e) {
            fail("Cannot delete item");
        }
    }
}
