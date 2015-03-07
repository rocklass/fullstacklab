package org.rocklass.fullstacklab.controller;

import org.junit.Test;
import org.rocklass.fullstacklab.test.ServiceIntegrationTest;
import org.springframework.http.ResponseEntity;

public class IndexIT extends ServiceIntegrationTest {
	@Override
	public String getRequestMapping() {
		return "/";
	}

	@Test
	public void getItems() throws Exception {
		ResponseEntity<String> response = getTemplate().getForEntity(getBase().toString(), String.class);
		// TODO write IT
	}
}
