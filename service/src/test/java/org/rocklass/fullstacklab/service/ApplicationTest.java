package org.rocklass.fullstacklab.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class ApplicationTest {

	@Test
	public void canGetContext() throws Exception {
		String[] args = new String[0];
		Application.main(args);
		ApplicationContext context = Application.getContext();
		
		assertThat(context, notNullValue());
	}
}