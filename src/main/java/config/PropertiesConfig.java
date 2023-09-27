package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(PropertiesConfig.class);
    protected static Properties PROPERTIES;

    static {
        var globalConfigFile = new File("src/test/resources/conf.properties");
        var localConfigFile = new File("src/test/resources/localConf.properties");

        Properties globalProperties = new Properties();
        Properties localProperties = new Properties();

        try {
            globalProperties.load(new FileInputStream(globalConfigFile));

            PROPERTIES = new Properties();
            PROPERTIES.putAll(globalProperties);

            if (localConfigFile.exists()) {
                localProperties.load(new FileInputStream(localConfigFile));
                PROPERTIES.putAll(localProperties);
            }

        } catch (IOException e) {
            LOGGER.error("Error in reading from property: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
