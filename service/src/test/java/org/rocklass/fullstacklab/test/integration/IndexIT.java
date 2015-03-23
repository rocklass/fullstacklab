package org.rocklass.fullstacklab.test.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.rocklass.fullstacklab.test.tools.FileUtility;
import org.springframework.http.ResponseEntity;

public class IndexIT extends ServiceIntegrationTest {
    @Override
    public String getRequestMapping() {
        return "/";
    }

    @Test
    public void getIndex() throws Exception {
        ResponseEntity<String> response = getTemplate().getForEntity(getBase().toString(), String.class);
        assertThat(response.getBody(), equalTo(FileUtility.getResourceFileAsString("static/index.html")));
    }
}
