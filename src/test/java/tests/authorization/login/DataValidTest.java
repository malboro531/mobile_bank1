package tests.authorization.login;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.android.authorization.ConfirmLoginPage;
import tests.authorization.AuthorizationMainTest;

public class DataValidTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Логин")
    @Story("Валидные данные")
    @TmsLink("27316")
    @Test
    @Parameters({"login", "password"})
    public void signInWithValidCredentialsTest(String login, String password) {
        ConfirmLoginPage confirmLoginPage = new ConfirmLoginPage();
        loginPageForLogin.isDisplaySignInScreenAndSectionsForLogin();

        var isDisplayConfirmLoginScreen = loginPageForLogin
                .tapOnIDOrLoginFieldAndInput(login)
                .tapOnPasswordFieldAndInput(password)
                .tapOnSignInButton()
                .isDisplayConfirmLoginScreenAndSections();

        var isDisplayMainMenu = confirmLoginPage
//                .inputCheckingCodeInFieldByCode(
//                        SOAPClientSAAJ.getDynamicCodeByHisNumber(confirmLoginPage.getNumberOfCheckingCode())
//                )
                .tapOnReadyButton()
                .tapOnFingerPrintCancelButtonIfExistIt()
                .tapRepeatedlyOnOnboardingNextButton()
                .isDisplayMainScreenContent();

        Assert.assertTrue( isDisplayConfirmLoginScreen && isDisplayMainMenu);
    }
}
