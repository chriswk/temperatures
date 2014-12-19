package com.chriswk.temperatures.netatmo;

import java.time.Instant;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.social.ExpiredAuthorizationException;
import org.springframework.social.oauth2.AccessGrant;

public class NetAtmoDevicesCommand extends HystrixCommand<String> {
    public static final Logger LOG = LogManager.getLogger();
    private final AccessGrant auth;

    public NetAtmoDevicesCommand(AccessGrant auth) {
        super(HystrixCommandGroupKey.Factory.asKey("NetAtmo"));
        this.auth = auth;
    }
    @Override
    protected String run() throws ExpiredAuthorizationException {
        Instant f = Instant.now();
        long now = f.getNano() * 1000000;
        if(auth.getExpireTime() < now) {
            throw new ExpiredAuthorizationException("authorization expired");
        } else {

        }
    }
}
