package tests.deposits;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.paymentsAndTransfers.BetweenAccountsPage;
import tests.paymentsAndTransfers.betweenAccounts.PaymentsAndTransfersBaseTest;

public class OutdoingTransferDepositTest extends PaymentsAndTransfersBaseTest {

    @Epic("Вклады и накопительный счет")
    @Feature("Вклад")
    @TmsLink("9619")
    @Test(description = "Исходящий перевод со счета вклада")
    public void outgoingTransferFromDepositAccountTest() {
        SoftAssert softAssert = new SoftAssert();
        var betweenAccountsPage = new BetweenAccountsPage();

        stepToChooseAccountRecipient(softAssert, betweenAccountsPage);
        var isDisplayModalForAccountRecipient = betweenAccountsPage
                .tapAndChooseDepositAccount()
                .tapOnAccountRecipient()
                .isDisplayModalWindowWithTransferForAccountRecipient();
        softAssert.assertTrue(isDisplayModalForAccountRecipient);
        var isDisplayModalTransferDetail = betweenAccountsPage
                .tapOnAvailableAccountForRecipient()
                .tapOnSumFieldAndFillAndTapOnTransferButton("100")
                .isDisplayModalWindowWithTransferDetails("100");
        softAssert.assertTrue(isDisplayModalTransferDetail);
        var isDisplaySuccessScreen = betweenAccountsPage
                .tapOnTransferButtonOnModalWindow()
                .isDisplaySuccessScreen();
        softAssert.assertTrue(isDisplaySuccessScreen);
        softAssert.assertAll();
    }
}
