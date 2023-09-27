package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.mobile.Waiters;

public class MobileElements {
    protected final AppiumDriver<MobileElement> driver;
    protected final Waiters waiters;

    public MobileElements(AppiumDriver<MobileElement> driver, Waiters waiters) {
        this.driver = driver;
        this.waiters = waiters;
    }
}
