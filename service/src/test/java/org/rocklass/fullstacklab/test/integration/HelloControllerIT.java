package org.rocklass.fullstacklab.test.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.rocklass.fullstacklab.controller.HelloController;
import org.springframework.http.ResponseEntity;

/**
 * Integration test of {@link HelloController}
 * 
 * @author rocklass
 *
 */
public class HelloControllerIT extends ServiceIntegrationTest {

    /**
     * Get request mapping for hello controller
     * 
     * @return /hello
     */
    @Override
    public String getRequestMapping() {
        return "/hello";
    }

    /**
     * Test GET method of {@link HelloController}
     */
    @Test
    public void hello() {
        final ResponseEntity<String> response = getTemplate().getForEntity(getBase().toString(), String.class);

        assertThat(response.getBody(), equalTo("Hello World"));
    }
}
