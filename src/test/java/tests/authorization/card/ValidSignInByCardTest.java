package tests.authorization.card;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.authorization.ConfirmLoginPage;
import tests.authorization.AuthorizationMainTest;

public class ValidSignInByCardTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Карта")
    @TmsLink("27316")
    @Test(description = "Валидный вход по карте")
    public void validSignInByCardTest() {
        SoftAssert softAssert = new SoftAssert();
        var confirmLoginPage = new ConfirmLoginPage();
        boolean isDisplayConfirmLoginByCardScreen = loginPageForLogin
                .tapOnByCardSection()
                .isDisplaySignInScreenAndSectionsForCard()
                .tapOnCardFieldAndInput("4301805015601446")
                .tapOnPasswordFieldAndInput("1111")
                .tapOnSignInButton()
                .isDisplayConfirmLoginScreenAndSections();
        boolean isDisplayMainMenu = confirmLoginPage
//                .inputCheckingCodeInFieldByCode(
//                        SOAPClientSAAJ.getDynamicCodeByHisNumber(confirmLoginPage.getNumberOfCheckingCode())
//                )
                .tapOnReadyButton()
                .tapOnFingerPrintCancelButtonIfExistIt()
                .tapRepeatedlyOnOnboardingNextButton()
                .isDisplayMainScreenContent();
        softAssert.assertTrue(isDisplayConfirmLoginByCardScreen);
        softAssert.assertTrue(isDisplayMainMenu);
    }
}
