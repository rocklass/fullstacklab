package org.rocklass.fullstacklab.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HelloControllerTest extends ControllerTest {

    @Override
    public String getUrl() {
        return "/hello";
    }

    @Before
    public void setUp() {
        setMvc(MockMvcBuilders.standaloneSetup(new HelloController()).build());
    }

    @Test
    public void getHello() throws Exception {
        // when
        final ResultActions resultAction = getMvc().perform(MockMvcRequestBuilders.get(getUrl()).accept(MediaType.APPLICATION_JSON));

        // then
        resultAction.andExpect(status().isOk());
        resultAction.andExpect(content().string(equalTo("Hello World")));
    }
}
