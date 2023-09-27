package tests.demoversion.paymentsAndTransfers.payments;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByQRCodeTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13088")
    public void paymentByQRCodeTest() {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnPaymentByQRCodeButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
