package com.chriswk.temperatures;

import java.net.URISyntaxException;

import com.chriswk.temperatures.config.TemperatureApp;
import com.chriswk.temperatures.netatmo.NetAtmoAuthCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String... args) throws URISyntaxException {
        ApplicationContext ctx = SpringApplication.run(TemperatureApp.class);
        LOGGER.info("Started");
        NetAtmoAuthCommand runner = (NetAtmoAuthCommand) ctx.getBean("netAtmoAuthCommand");
        runner.toObservable().subscribe((token) -> {
            LOGGER.info("Authenticated: " +token.getAccessToken());
        });
    }
}
