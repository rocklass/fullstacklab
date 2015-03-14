package org.rocklass.fullstacklab.test.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.rocklass.fullstacklab.model.Item;
import org.springframework.http.ResponseEntity;

public class ItemControllerIT extends ServiceIntegrationTest {
	@Override
	public String getRequestMapping() {
		return "/items";
	}

	@Test
	public void findItems() throws Exception {
		ResponseEntity<List> response = getTemplate().getForEntity(getBase().toString(), List.class);
		System.out.println(response.getBody());// TODO write IT
	}
	
	@Test
	public void addItem() throws Exception {
		Item item = new Item();
		ResponseEntity<Item> response = getTemplate().postForEntity(getBase().toString(), item, Item.class);
		// TODO write IT
	}
	
	@Test
	public void updateItem() throws Exception {
		Item item = new Item();
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("id", "1");
		getTemplate().put(getBase().toString() + "/{id}", item, urlVariables);
		// TODO write IT
	}
	
	@Test
	public void deleteItem() throws Exception {
		Item item = new Item();
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("id", "1");
		getTemplate().delete(getBase().toString() + "/{id}", urlVariables);
		// TODO write IT
	}
}
