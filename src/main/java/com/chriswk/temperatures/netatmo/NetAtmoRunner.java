package com.chriswk.temperatures.netatmo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NetAtmoRunner {
    private static final Logger LOGGER = LogManager.getLogger();
    @Value("${TEMPERATURES_CLIENT_ID}")
    public String client_id;

    @Value("${TEMPERATURES_CLIENT_SECRET}")
    public String client_secret;

    @Value("${TEMPERATURES_USERNAME}")
    public String username;

    @Value("${TEMPERATURES_PASSWORD}")
    public String password;

    public NetAtmoClient client;

    @Autowired
    public NetAtmoRunner(NetAtmoClient client) {
        this.client = client;
    }

    public void loginTest() {
        LOGGER.info("client_id: [{}], client_secret: [{}], password: [{}]", client_id, client_secret, password);
        NetAtmo netAtmo = client.getClient();
        LOGGER.info("Logging {}", netAtmo.auth(client_id, client_secret, "password", username, password, "read_station"));
    }
}
