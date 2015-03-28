package org.rocklass.fullstacklab.controller;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Abstract class defining REST controllers testing
 * 
 * @author rocklass
 *
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class ControllerTest {
    
    /**
     * Mocked Spring MVC
     */
    private MockMvc mvc;

    /**
     * Content-type used by REST controller
     */
    private String contentType = "application/json;charset=UTF-8";

    /**
     * Pattern URL for variable id
     */
    public static final String URL_VARIABLE_ID = "/{id}";

    /**
     * Get mocked Spring MVC
     * 
     * @return mocked Spring MVC
     */
    public MockMvc getMvc() {
        return mvc;
    }

    /**
     * Set mocked Spring MVC
     * 
     * @param mvc
     *            mocked Spring MVC
     */
    public void setMvc(final MockMvc mvc) {
        this.mvc = mvc;
    }

    /**
     * Get content type
     * 
     * @return content type as string
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Set content type
     * 
     * @param content
     *            type as string
     */
    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    /**
     * Get URL of the REST controller to test
     * 
     * @return URL
     */
    public abstract String getUrl();
}
