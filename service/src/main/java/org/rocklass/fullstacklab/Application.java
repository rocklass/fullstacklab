package org.rocklass.fullstacklab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Main application
 * 
 * @author rocklass
 *
 */
@SpringBootApplication
public class Application {
    /**
     * Application context
     */
    private static ApplicationContext context;

    /**
     * Main method
     * 
     * @param args
     *            application arguments
     */
    public static void main(final String[] args) {
        context = SpringApplication.run(Application.class, args);
    }

    /**
     * Get application context
     * 
     * @return application context
     */
    public static ApplicationContext getContext() {
        return context;
    }
}
