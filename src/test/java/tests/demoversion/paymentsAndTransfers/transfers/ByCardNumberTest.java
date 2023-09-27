package tests.demoversion.paymentsAndTransfers.transfers;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ByCardNumberTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13085")
    @Parameters({"cardNumber", "sum", "comment"})
    public void paymentAndTransferByCardNumberTest(String cardNumber, String sum, String comment) {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnByCardNumberButton()
                .fillInFieldsForTransferByCardNumber(cardNumber, sum, comment)
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
