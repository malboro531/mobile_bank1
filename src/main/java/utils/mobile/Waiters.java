package utils.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.AppiumFunction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static core.InitialDriver.getAndroidDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.testng.Assert.fail;

public class Waiters {
    protected static final Logger LOGGER = LoggerFactory.getLogger(Waiters.class);

    private final AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    public static final long IMPLICITLY_WAIT = 15L;
    protected static final long EXPLICITLY_WAIT = 5L;
    protected static final long WAIT_ELEMENT_NOT_EXIST_TIMEOUT_IN_SECONDS = 5L;


    private static Waiters instance;

    public static Waiters getWaiters() {
        if (instance == null) {
            return new Waiters();
        }
        return instance;
    }

    private Waiters() {
        this.driver = getAndroidDriver();
        this.wait = new WebDriverWait(getAndroidDriver(), EXPLICITLY_WAIT);
    }

    public void waitForAlert() {
        waiter(EXPLICITLY_WAIT).until(ExpectedConditions.alertIsPresent());
    }

    public MobileElement getElementAfterWaitForVisibility(MobileElement mobileElement) {
        return (MobileElement) waiter(EXPLICITLY_WAIT).until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public void waitForVisibility(MobileElement mobileElement) {
        waiter(EXPLICITLY_WAIT).until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public MobileElement waitForElementClickable(MobileElement element) {
        return (MobileElement) waiter(EXPLICITLY_WAIT).until(elementToBeClickable(element));
    }

    public MobileElement waitForElementClickable(MobileElement element, Long duration) {
        return (MobileElement) waiter(duration).until(elementToBeClickable(element));
    }

    public void waitForChangeAttribute(By by, String attribute, String attributeValue) {
        waiter(EXPLICITLY_WAIT).until(ExpectedConditions.attributeContains(by, attribute, attributeValue));
    }

    public void waitForElementVisibleNot(By byElement) {
        waitUntilFunctionIsTrue(func -> !isElementExist(byElement));
    }

    public void waitForElementVisibleNot(MobileElement element) {
        waitUntilFunctionIsTrue(func -> !isElementExist(element));
    }

    public boolean isElementExist(By locator) {
        var allElements = driver.findElements(locator);
        return allElements != null && !allElements.isEmpty();
    }

    public boolean isElementExist(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean isElementExist(MobileElement element, Long duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void waitUntilFunctionIsTrue(AppiumFunction<AppiumDriver<MobileElement>, Object> function) {
        waiter(EXPLICITLY_WAIT).until(function);
    }

    protected void waitUntilFunctionIsTrue(AppiumFunction<AppiumDriver<MobileElement>, Object> function, String errorMessage) {
        waiter(errorMessage).until(function);
    }

    public void waitForPageVisible(MobileElement element) {
        var pageName = getClass().getSimpleName();
        LOGGER.info("Wait page: " + pageName);

        try {
            waitForVisibility(element);
        } catch (Exception e) {
            var errorMessage = pageName + " was not loaded after " + EXPLICITLY_WAIT + " seconds.\n";
            fail(errorMessage);
            LOGGER.error(errorMessage);
            e.printStackTrace();
        }

        LOGGER.info("Page " + pageName + " loaded");
    }

    protected void waitForPageNotVisible(String rootPageLocator) {
        var pageName = getClass().getSimpleName();

        try {
            waitForElementVisibleNot(By.xpath(rootPageLocator));
        } catch (Exception e) {
            fail(pageName + " was not closed after " + EXPLICITLY_WAIT + " seconds.\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private FluentWait<AppiumDriver<MobileElement>> waiter(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    private FluentWait<AppiumDriver<MobileElement>> waiter(String errorMessage) {
        return waiter(EXPLICITLY_WAIT)
                .withMessage(errorMessage + "\nWait timeout: " + EXPLICITLY_WAIT + " seconds.\n");
    }

    public void waitSomeSecond(Integer seconds) {
        int timeOnMills = seconds * 1000;
        try {
            Thread.sleep(timeOnMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

