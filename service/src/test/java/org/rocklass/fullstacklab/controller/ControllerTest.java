package org.rocklass.fullstacklab.controller;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
public abstract class ControllerTest {
    private MockMvc mvc;

    private String contentType = "application/json;charset=UTF-8";
    
    public static final String URL_VARIABLE_ID = "/{id}";

    public MockMvc getMvc() {
        return mvc;
    }

    public void setMvc(final MockMvc mvc) {
        this.mvc = mvc;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public abstract String getUrl();
}
