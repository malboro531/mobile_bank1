package tests.demoversion.paymentsAndTransfers.payments;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePhoneTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13093")
    public void homePhoneTest() {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnHomePhoneButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
