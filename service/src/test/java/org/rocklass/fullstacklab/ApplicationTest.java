package org.rocklass.fullstacklab;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ApplicationTest {

	@Test
	public void canGetContext() {
		final String[] args = new String[0];
		Application.main(args);
		
		assertThat(Application.getContext(), notNullValue());
	}
}
