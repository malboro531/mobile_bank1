package utils;

import core.InitialDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Map;

public class EnvVariablesGetter {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnvVariablesGetter.class);

    public static String getValueFromEnvironmentVariableByKey(String key) {
        LOGGER.info(key + " Value:- " + System.getenv(key.toUpperCase(Locale.ROOT)));

        return System.getenv()
                .entrySet()
                .stream()
                .filter(entryKey -> entryKey.getKey().equals(key))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow();
    }
}
