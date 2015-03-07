package org.rocklass.fullstacklab.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.rocklass.fullstacklab.test.ServiceIntegrationTest;
import org.springframework.http.ResponseEntity;

public class HelloControllerIT extends ServiceIntegrationTest {
	
	@Override
	public String getRequestMapping() {
		return "/hello";
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = getTemplate().getForEntity(
				getBase().toString(), String.class);
		assertThat(response.getBody(), equalTo("Hello World"));
	}
}
