package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PhoneNumberAdditionTest extends MoreMainTest {

    @Test
    @TmsLink("27213")
    @Parameters("phoneNumber")
    public void phoneNumberAddTest(String phoneNumber) {
        var actualResult = demoMorePage
                .tapOnSmsAndEmailNotifications()
                .tapOnNewNumberAddition()
                .tapOnPhoneNumberFieldAndWriteNumber(phoneNumber)
                .tapOnDone()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
