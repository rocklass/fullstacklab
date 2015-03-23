package org.rocklass.fullstacklab.test.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.rocklass.fullstacklab.model.Item;
import org.rocklass.fullstacklab.test.tools.RandomFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

public class ItemControllerIT extends ServiceIntegrationTest {
    @Override
    public String getRequestMapping() {
        return "/items";
    }

    @Test
    public void findItems() throws Exception {
        // when
        List<Item> items = new ArrayList<Item>();
        @SuppressWarnings("unchecked")
        ResponseEntity<List<Item>> response = (ResponseEntity<List<Item>>) getTemplate().getForEntity(getBase().toString(), items.getClass());

        // then
        assertThat(response.getBody(), instanceOf(items.getClass()));
    }

    @Test
    public void addItem() throws Exception {
        // given
        Item item = RandomFactory.createItem();

        // when
        ResponseEntity<Item> response = getTemplate().postForEntity(getBase().toString(), item, Item.class);

        // then
        assertThat(response.getBody().isChecked(), equalTo(item.isChecked()));
        assertThat(response.getBody().getDescription(), equalTo(item.getDescription()));
    }

    @Test
    public void updateItem() throws Exception {
        Item item = RandomFactory.createItem();
        Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("id", item.getId().toString());

        try {
            getTemplate().put(getBase().toString() + "/{id}", item, urlVariables);
        } catch (RestClientException e) {
            fail("Cannot put item");
        }
    }

    @Test
    public void deleteItem() throws Exception {
        Item item = RandomFactory.createItem();
        Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("id", item.getId().toString());
        try {
            getTemplate().delete(getBase().toString() + "/{id}", urlVariables);
        } catch (RestClientException e) {
            fail("Cannot delete item");
        }
    }
}
