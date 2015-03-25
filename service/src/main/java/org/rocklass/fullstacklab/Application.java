package org.rocklass.fullstacklab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    private static ApplicationContext context;
    
    public static void main(final String[] args) {
        context = SpringApplication.run(Application.class, args);
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
