package tests.demoversion.paymentsAndTransfers.payments;

import tests.demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EducationTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13095")
    public void educationPaymentsTest() {
        var actualResult = demoPaymentsAndTransfersPage
                .tapOnEducationButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
