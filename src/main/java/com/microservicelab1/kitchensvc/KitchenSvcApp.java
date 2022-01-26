package com.microservicelab1.kitchensvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class KitchenSvcApp {
    private static Logger log = LoggerFactory.getLogger(KitchenSvcApp.class);

    public static void main(String[] args) {
        SpringApplication.run(KitchenSvcApp.class, args);
    }

    @Value("${kitchen-val:kitchen}")
    private String configVal;

    @PostMapping(path = "ticket/create/{customerId}")
    public String createTicket(@PathVariable(name = "customerId") String customerId) {
        log.info("received create ticket req with customer id:{}", customerId);
        return String.format("received:%s", configVal);
    }
}
