package tests.demoversion.paymentsAndTransfers.payments;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InternetAndTVByVendorFromListTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("27932")
    @Parameters({"account", "sum"})
    public void internetAndTVByVendorFromListPaymentTest(String account, String sum) {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnInternetAndTVButton()
                .tapOnByVendorPAOButton()
                .fillInFields(account, sum)
                .tapOnNextButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
