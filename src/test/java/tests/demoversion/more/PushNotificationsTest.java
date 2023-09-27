package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PushNotificationsTest extends MoreMainTest {

    @Test
    @TmsLink("24527")
    public void pushNotifications() {
        var actualResult = demoMorePage
                .tapOnPushNotificationsToggle()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
