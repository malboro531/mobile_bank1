package tests.demoversion.paymentsAndTransfers.transfers;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SystemOfFastPaymentTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13087")
    public void systemOfFastPaymentsTest() {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnSBPButton()
                .tapOnByPhoneNumberButtonThroughSBP()
                .fillInFieldsForSBP("1500.56", "тест №1")
                .tapOnTransferSBPButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
