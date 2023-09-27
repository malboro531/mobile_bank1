package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNumberForSmsNoticesTest extends MoreMainTest {

    @Test
    @TmsLink("31901")
    public void deleteNumberForSmsNotificationsTest() {
        var actualResult = demoMorePage
                .tapOnSmsAndEmailNotifications()
                .tapOnDeleteFirstNumber()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
