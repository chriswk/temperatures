package feign;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Logger extends feign.Logger {
    private final Logger logger;
    public Log4j2Logger() {
        this(feign.Logger.class);
    }

    public Log4j2Logger(Class<?> clazz) {
        this(LogManager.getLogger(clazz));
    }

    public Log4j2Logger(String name) {
        this(LogManager.getLogger(name));
    }

    public Log4j2Logger(Logger logger) {
        this.logger = logger;
    }

    @Override protected void logRequest(String configKey, Level logLevel, Request request) {
        logger.info("key: {}, request: {}", configKey, request);
        if (logger.isDebugEnabled()) {
            super.logRequest(configKey, logLevel, request);
        }
    }

    @Override protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        if (logger.isDebugEnabled()) {
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
        return response;
    }

    @Override protected void log(String configKey, String format, Object... args) {
        // Not using SLF4J's support for parameterized messages (even though it would be more efficient) because it would
        // require the incoming message formats to be SLF4J-specific.
        logger.info(String.format(methodTag(configKey) + format, args));
    }
}
