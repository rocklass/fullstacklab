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

/**
 * Test of class {@link HelloController}
 * 
 * @author rocklass
 *
 */
public class HelloControllerTest extends ControllerTest {

    /**
     * Get URL of hello controller
     * 
     * @return /hello
     */
    @Override
    public String getUrl() {
        return "/hello";
    }

    /**
     * Set up test
     */
    @Before
    public void setUp() {
        setMvc(MockMvcBuilders.standaloneSetup(new HelloController()).build());
    }

    /**
     * Test method
     * {@link HelloController#hello()}
     * 
     * @throws Exception
     *             test fails
     */
    @Test
    public void hello() throws Exception {
        // when
        final ResultActions resultAction = getMvc().perform(MockMvcRequestBuilders.get(getUrl()).accept(MediaType.APPLICATION_JSON));

        // then
        resultAction.andExpect(status().isOk());
        resultAction.andExpect(content().string(equalTo("Hello World")));
    }
}
