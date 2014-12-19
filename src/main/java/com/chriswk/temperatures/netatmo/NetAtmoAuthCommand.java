package com.chriswk.temperatures.netatmo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class NetAtmoAuthCommand extends HystrixCommand<AccessGrant> {
    private static final Logger LOGGER = LogManager.getLogger();
    @Value("${TEMPERATURES_CLIENT_ID}")
    public String client_id;

    @Value("${TEMPERATURES_CLIENT_SECRET}")
    public String client_secret;

    @Value("${TEMPERATURES_USERNAME}")
    public String username;

    @Value("${TEMPERATURES_PASSWORD}")
    public String password;

    @Value("${TEMPERATURES_ACCESS_TOKEN}")
    public String access_token;

    @Value("${TEMPERATURES_REFRESH_TOKEN}")
    public String refresh_token;

    public NetAtmoAuthCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("NetAtmo"));
    }
    @Override
    protected AccessGrant run() throws Exception {
        LOGGER.info("client_id: [{}], client_secret: [{}], password: [{}]", client_id, client_secret, password);
        OAuth2Template template = new OAuth2Template(client_id, client_secret, "", "https://api.netatmo.net/oauth2/token");
        MultiValueMap<String, String> extraParams = new LinkedMultiValueMap<>();
        return template.exchangeCredentialsForAccess(username, password, extraParams);
    }
}
