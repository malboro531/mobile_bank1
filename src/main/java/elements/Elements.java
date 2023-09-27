package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.mobile.Waiters;

public class Elements extends MobileElements {
    private static final Logger LOGGER = LoggerFactory.getLogger(Elements.class);

    public Elements(AppiumDriver<MobileElement> driver, Waiters waiters) {
        super(driver, waiters);
    }


    public String getTextFromElement(MobileElement mobileElement) {
        var elementWithText = waiters.getElementAfterWaitForVisibility(mobileElement);

        return elementWithText.getText();
    }

    public boolean isSelectedElement(MobileElement mobileElement) {
        try {
            return mobileElement.isSelected();
        } catch (Exception e) {
            LOGGER.error("Element " + mobileElement.toString() + " is not selected");
            return false;
        }
    }

    public boolean isEnableElement(MobileElement mobileElement) {
        try {
            waiters.waitForVisibility(mobileElement);
            return mobileElement.isEnabled();
        } catch (Exception e) {
            LOGGER.error("Element " + mobileElement.toString() + " is not exist or invisible");
            return false;
        }
    }

    public boolean isVisibleElement(MobileElement mobileElement) {
        try {
            waiters.waitForVisibility(mobileElement);
            return true;
        } catch (Exception ElementNotVisible) {
            LOGGER.error("Element " + mobileElement.toString() + " is not visible");
            return false;
        }
    }

    public boolean isNotVisibleElement(MobileElement mobileElement) {
        try {
            waiters.waitForVisibility(mobileElement);
            return true;
        } catch (Exception ElementNotVisible) {
            LOGGER.error("Element " + mobileElement.toString() + " is not visible");
            return false;
        }
    }

    public void searchFieldAndSendKey(MobileElement mobileElement, String key) {
        var searchField = waiters.waitForElementClickable(mobileElement);
        searchField.clear();
        searchField.sendKeys(key);
    }

    public void sendKeyFromAction(String key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).perform();
    }

    public void sendKeyFromAndroidKeyboard(CharSequence sequence) {
        Actions action = new Actions(driver);
        action.sendKeys(sequence).perform();
    }

    public boolean isElementExist(MobileElement mobileElement) {
        return waiters.isElementExist(mobileElement);
    }

    public boolean isElementExist(MobileElement mobileElement, Long duraion) {
        return waiters.isElementExist(mobileElement, duraion);
    }
}
