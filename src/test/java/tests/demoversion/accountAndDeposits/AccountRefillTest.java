package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.demoversion.DemoVersionMainTest;


public class AccountRefillTest extends DemoVersionMainTest {
    private static final String TRANSFER_SUM = "2000";

    @TmsLink("31838")
    @Test(description = "Пополнить. Со своего счёта")
    public void isExistBeforeSelectedAccountTest() {
        SoftAssert softAssert = new SoftAssert();
        demoAccountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnFromMyAccountButton();
        softAssert.assertTrue(demoAccountPage.isExistSelectedAccount());
        var actualResult = demoAccountPage
                .tapOnTransferFromAccountSender()
                .chooseDepositAccountCheckbox()
                .inputSumForTransfer(TRANSFER_SUM)
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();
        softAssert.assertTrue(actualResult);
        softAssert.assertAll();
    }
}
