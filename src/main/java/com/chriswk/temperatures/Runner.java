package com.chriswk.temperatures;

import com.chriswk.temperatures.config.Temperature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String... args) {
        ApplicationContext ctx = SpringApplication.run(Temperature.class);
        LOGGER.info("Started");
    }
}
