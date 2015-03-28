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

/**
 * Abstract class defining integration test for REST controller
 * 
 * @author rocklass
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public abstract class ServiceIntegrationTest {
    /**
     * Port of REST web service
     */
    @Value("${local.server.port}")
    private transient int port;

    /**
     * Base URL of REST web service
     */
    private URL base;

    /**
     * Test REST template
     */
    private RestTemplate template;

    /**
     * Set up test
     */
    @Before
    public void setUp() throws Exception {
        base = new URL("http://localhost:" + port + getRequestMapping());
        template = new TestRestTemplate();
    }

    /**
     * Get port of REST web service
     * 
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * Get base URL of REST web service
     * 
     * @return base URL
     */
    public URL getBase() {
        return base;
    }

    /**
     * Set base URL of REST web service
     * 
     * @param base
     */
    public void setBase(final URL base) {
        this.base = base;
    }

    /**
     * Get test REST template
     * 
     * @return REST template
     */
    public RestTemplate getTemplate() {
        return template;
    }

    /**
     * Set test REST template
     * 
     * @param template
     *            REST template
     */
    public void setTemplate(final RestTemplate template) {
        this.template = template;
    }

    /**
     * Get request mapping for controller
     * 
     * @return request mapping
     */
    public abstract String getRequestMapping();
}
