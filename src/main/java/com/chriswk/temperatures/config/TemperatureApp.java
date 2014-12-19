package com.chriswk.temperatures.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.chriswk")

public class TemperatureApp {

    public RestTemplate restTemplate() {
        
        return new RestTemplate();
    }

}