package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends MoreMainTest {

    @Test
    @TmsLink("31899")
    public void changePasswordTest() {
        var actualResult = demoMorePage
                .tapOnChangePassword()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
