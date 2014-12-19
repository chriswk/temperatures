package com.chriswk.temperatures.netatmo;

import java.util.Map;

import com.google.common.base.Joiner;
import feign.Feign;
import feign.Log4j2Logger;
import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class NetAtmoClient {
    private static final Logger LOGGER = LogManager.getLogger();
    public NetAtmo client;

    public NetAtmoClient() {
        this.client = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new Encoder() {
                    @Override
                    public void encode(Object object, RequestTemplate template) {
                        if (object instanceof Map) {
                            template.body(Joiner.on(',').withKeyValueSeparator("=").join((Map) object));
                        } else {
                            template.body(object.toString());
                        }
                    }
                })
                .logger(new Log4j2Logger(LOGGER))
                .target(NetAtmo.class, "https://api.netatmo.net");
    }

    public NetAtmo getClient() {
        return client;
    }
}
