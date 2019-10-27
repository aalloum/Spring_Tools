package com.springtools.springbootlogging.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ALLOUM on 25/10/2019
 */

@RestController
public class SpringBootLoggingController {

    Logger log = LoggerFactory.getLogger(SpringBootLoggingController.class);

    @GetMapping("/logger/{name}")
    public String greeting(@PathVariable String name){
        log.debug("DEBUG : Request {}", name);
        log.info("DEBUG : Request {}", name);
        if (name.equalsIgnoreCase("test")) {
            throw new RuntimeException("Opps Exception raised....");
        }
        String response = "Hi " + name + " Welcome to Java Techie";
        log.debug("DEBUG : Response {}", response);
        log.info("INFO : Response {}", response);
        return response;
    }
}
