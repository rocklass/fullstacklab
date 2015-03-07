package org.rocklass.fullstacklab.controller;

import org.junit.Test;
import org.rocklass.fullstacklab.test.ServiceIntegrationTest;
import org.springframework.http.ResponseEntity;

public class ItemControllerIT extends ServiceIntegrationTest {
	@Override
	public String getRequestMapping() {
		return "/items";
	}

	@Test
	public void getItems() throws Exception {
		ResponseEntity<String> response = getTemplate().getForEntity(getBase().toString(), String.class);
		// TODO write IT
	}
}
