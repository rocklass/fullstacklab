package org.rocklass.fullstacklab.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello World REST Controller
 * 
 * @author rocklass
 *
 */
@RestController
public class HelloController {

    /**
     * Hello World GET Controller
     * 
     * @return Hello World
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
