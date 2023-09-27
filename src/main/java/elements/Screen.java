package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.mobile.Waiters;

import java.time.Duration;

import static utils.mobile.Waiters.getWaiters;

public class Screen extends MobileElements {
    protected static final Logger LOGGER = LoggerFactory.getLogger(Screen.class);

    public Screen(AppiumDriver<MobileElement> driver, Waiters waiters) {
        super(driver, waiters);
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public void scrollablePageAndroidByText(String text) {
        ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(" + "\"" + text + "\"" + ").instance(0));");
        LOGGER.info("Page is scrollable");
    }

    public void scrollablePageIOS(WebElement webElement) {
        TouchActions action = new TouchActions(driver);
        action.scroll(webElement, 10, 100);
        action.perform();
    }

    public void scrollToElementBy(String text) {
        ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"))");
        LOGGER.info("Page is scrollable");

    }

    public void swipeScreenWithPressTime(Direction dir, int pressTime, Point pointStart) {
        final int ANIMATION_TIME = 200;

        Point pointEnd;
        PointOption pointOptionStart, pointOptionEnd;

        int edgeBorder = 10;

        Dimension dims = driver.manage().window().getSize();
        getWaiters().waitSomeSecond(1);

        if (pointStart == null) {
            pointStart = new Point(dims.width / 2, dims.height / 2);
        }

        switch (dir) {
            case DOWN: // center of footer
                pointEnd = new Point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointEnd = new Point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointEnd = new Point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointEnd = new Point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir.toString() + "' NOT supported");
        }

        pointOptionStart = PointOption.point(pointStart.x, pointStart.y);
        pointOptionEnd = PointOption.point(pointEnd.x, pointEnd.y);

        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(pressTime)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    /**
     * @param heightPart  - part of the height by which to divide the whole height
     * @param widthPart - part of the width by which to divide the whole width
     */
    public Point setPointForSwipe(Float heightPart, Float widthPart) {
        var dims = driver
                .manage()
                .window()
                .getSize();
        return new Point( (int) (dims.width / widthPart), (int) (dims.height / heightPart));
    }
}
