package org.rocklass.fullstacklab;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test of class {@link Application}
 * 
 * @author rocklass
 *
 */
public class ApplicationTest {

    /**
     * Test method {@link Application#main(String[]) and
     * {@link Application#getContext()}
     */
    @Test
    public void canGetContextAfterMain() {
        // when
        final String[] args = new String[0];
        Application.main(args);

        // then
        assertThat(Application.getContext(), notNullValue());
    }
}
