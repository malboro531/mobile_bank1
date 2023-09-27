package tests.demoversion.paymentsAndTransfers.transfers;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BetweenAccountsTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13084")
    @Parameters("sum")
    public void transferBetweenAccountsTest(String sum) {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnBetweenAccountsButton()
                .fillInFields(sum)
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
