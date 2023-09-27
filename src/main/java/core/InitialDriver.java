package core;

import config.PropertiesConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.YamlParser;
import utils.mobile.Waiters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public abstract class InitialDriver {
    private static final String APPIUM_URL = "http://0.0.0.0:4723/wd/hub";
    private static final Logger LOGGER = LoggerFactory.getLogger(InitialDriver.class);
    private static final YamlParser yamlParser = new YamlParser();
    private static AppiumDriver<MobileElement> driver;
    private static DesiredCapabilities caps;


    private static AppiumDriver<MobileElement> initializeDriver() throws MalformedURLException {
        switch (caps.getPlatform()) {
            case ANDROID:
                return new AndroidDriver<>(new URL(APPIUM_URL), caps);
            case IOS:
                return new IOSDriver<>(new URL(APPIUM_URL), caps);
            default:
                LOGGER.error("Invalid platform");
        }
        return null;
    }

    private static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            try {
                driver = initializeDriver();
                Objects.requireNonNull(driver).manage().timeouts().implicitlyWait(Waiters.IMPLICITLY_WAIT, TimeUnit.SECONDS);
                LOGGER.info("Driver is started");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static AndroidDriver<MobileElement> getAndroidDriver() {
        setCapabilities();
        try {
            if (caps.getPlatform().equals(Platform.ANDROID)) {
                return (AndroidDriver<MobileElement>) getDriver();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(String.format("Invalid platform in caps: %s", caps.getPlatform().name()));
        }
        return null;
    }


    private static void setCapabilities() {
        if (caps == null) {
            caps = new DesiredCapabilities();
            var capabilities = yamlParser.getCapabilitiesForDevice("realme6Pro");
            switch (capabilities.getDevice().getPlatformName()) {
                case "Android":
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, capabilities.getDevice().getDeviceName());
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, capabilities.getDevice().getPlatformName());
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, capabilities.getDevice().getPlatformVersion());
                    caps.setCapability(MobileCapabilityType.NO_RESET, false);
                    caps.setCapability("autoGrantPermission", true);
                    caps.setCapability("appActivity", capabilities.getMyAppActivity());
                    caps.setCapability("appPackage", capabilities.getMyAppPackage());
                    break;
                case "IOS":
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesConfig.getProperty("iosDeviceName"));
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesConfig.getProperty("iosPlatformName"));
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesConfig.getProperty("iosPlatformVersion"));
                    caps.setCapability(MobileCapabilityType.NO_RESET, false);
                    caps.setCapability(MobileCapabilityType.UDID, PropertiesConfig.getProperty("iosUdId"));
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesConfig.getProperty("iosAutomationName"));
                    caps.setCapability("bundleId", PropertiesConfig.getProperty("iosBundleId"));
                    break;
                default:
                    LOGGER.info("Driver is not initialize");
                    break;
            }
        }
    }
}
