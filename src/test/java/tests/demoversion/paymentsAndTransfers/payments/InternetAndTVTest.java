package tests.demoversion.paymentsAndTransfers.payments;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InternetAndTVTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13094")
    public void internetAndTVPaymentsTest() {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnInternetAndTVButton()
                .tapOnByQRCodePaymentButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
