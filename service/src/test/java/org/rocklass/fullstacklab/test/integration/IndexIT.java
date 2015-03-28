package org.rocklass.fullstacklab.test.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.rocklass.fullstacklab.test.tools.FileUtility;
import org.springframework.http.ResponseEntity;

/**
 * Integration test of index
 * 
 * @author rocklass
 *
 */
public class IndexIT extends ServiceIntegrationTest {
    /**
     * Get request mapping of index
     * 
     * @return /
     */
    @Override
    public String getRequestMapping() {
        return "/";
    }

    /**
     * Test GET method in index
     */
    @Test
    public void index() throws Exception {
        final ResponseEntity<String> response = getTemplate().getForEntity(getBase().toString(), String.class);
        
        assertThat(response.getBody(), equalTo(FileUtility.getResourceFileAsString("static/index.html")));
    }
}
