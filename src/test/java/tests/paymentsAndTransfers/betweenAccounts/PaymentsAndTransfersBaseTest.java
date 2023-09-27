package tests.paymentsAndTransfers.betweenAccounts;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.android.paymentsAndTransfers.BetweenAccountsPage;
import pages.android.paymentsAndTransfers.PaymentsAndTransfersPage;

public class PaymentsAndTransfersBaseTest extends BaseTest {
    protected PaymentsAndTransfersPage paymentsAndTransfersPage = new PaymentsAndTransfersPage();

    @BeforeClass
    public void passTheOnboarding() {
        personalCabinetMainPage
                .tapOnPaymentsButton()
                .isDisplayOnboardingAboutFastPayment();
        paymentsAndTransfersPage
                .tapOnNextAfterFastPaymentOnboardingButton()
                .isDisplayOnboardingAboutPaymentsByQRCode();
        paymentsAndTransfersPage.tapOnNextPaymentByQRCodeOnboardingButton();
    }

    protected void stepToChooseAccountRecipient(SoftAssert softAssert, BetweenAccountsPage betweenAccountsPage) {
        var isDisplayPaymentsAndTransfersScreen = paymentsAndTransfersPage
                .tapOnNextPaymentByQRCodeOnboardingButton()
                .isDisplayPaymentsScreenWithSections();
        softAssert.assertTrue(isDisplayPaymentsAndTransfersScreen);
        var isDisplayBetweenAccountsScreen = paymentsAndTransfersPage
                .tapOnBetweenAccountsIcon()
                .isDisplayBetweenAccountsScreen();
        softAssert.assertTrue(isDisplayBetweenAccountsScreen);
        var isDisplayModalWindow = betweenAccountsPage
                .tapOnAccountTransferFrom()
                .isExistModalWindowWithTransferFromAccount();
        softAssert.assertTrue(isDisplayModalWindow);
    }
}
