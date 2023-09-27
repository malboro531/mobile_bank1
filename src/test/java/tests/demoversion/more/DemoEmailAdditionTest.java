package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoEmailAdditionTest extends MoreMainTest {

    @Test
    @TmsLink("27214")
    @Parameters("email")
    public void addNewEmailTest(String email) {
        var actualResult = demoMorePage
                .tapOnSmsAndEmailNotifications()
                .tapOnNewEmailAddition()
                .inputEmailInEmailField(email)
                .tapOnDone()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
