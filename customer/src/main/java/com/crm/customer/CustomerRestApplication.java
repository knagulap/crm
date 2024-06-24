package com.crm.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableWebFluxSecurity
@SpringBootApplication
public class CustomerRestApplication {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRestApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(CustomerRestApplication.class, args);
        logger.info("This is an info message application started");
    }

}
