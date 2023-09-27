package tests.demoversion.paymentsAndTransfers.payments;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InternetAndTVByVendorBySearchTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("27934")
    @Parameters({"inn", "account", "sum"})
    public void internetAndTVByVendorThroughSearchByINNTest(String inn, String account, String sum) {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnInternetAndTVButton()
                .fillInFieldByNameOrINN(inn)
                .tapOnPAOVendor()
                .fillInFields(account, sum)
                .tapOnNextButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
