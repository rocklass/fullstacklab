package org.rocklass.fullstacklab.test.integration;

import java.net.URL;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.rocklass.fullstacklab.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public abstract class ServiceIntegrationTest {
    @Value("${local.server.port}")
    private transient int port;

    private URL base;

    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        base = new URL("http://localhost:" + port + getRequestMapping());
        template = new TestRestTemplate();
    }

    public int getPort() {
        return port;
    }

    public URL getBase() {
        return base;
    }

    public void setBase(final URL base) {
        this.base = base;
    }

    public RestTemplate getTemplate() {
        return template;
    }

    public void setTemplate(final RestTemplate template) {
        this.template = template;
    }

    public abstract String getRequestMapping();
}
