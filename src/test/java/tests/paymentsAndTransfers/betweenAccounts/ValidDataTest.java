package tests.paymentsAndTransfers.betweenAccounts;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.paymentsAndTransfers.BetweenAccountsPage;

public class ValidDataTest extends PaymentsAndTransfersBaseTest {

    @Epic("Платежи и переводы")
    @Feature("Переводы между счетами")
    @TmsLink("10392")
    @Test(description = "Валидные данные")
    public void betweenAccountsValidDataTest() {
        SoftAssert softAssert = new SoftAssert();
        var betweenAccountsPage = new BetweenAccountsPage();

        stepToChooseAccountRecipient(softAssert, betweenAccountsPage);
        var isDisplayModalForAccountRecipient = betweenAccountsPage
                .tapOnAvailableAccount()
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
        betweenAccountsPage.tapOnBackToPaymentsButton();
        softAssert.assertTrue(isDisplaySuccessScreen);
        softAssert.assertAll();
    }
}
