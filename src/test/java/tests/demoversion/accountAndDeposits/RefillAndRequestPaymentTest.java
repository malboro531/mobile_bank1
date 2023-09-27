package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefillAndRequestPaymentTest extends DemoVersionMainTest {

    @TmsLink("31841")
    @Test
    public void refillAndRequestPayment() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnRequestPaymentButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
