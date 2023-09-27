package tests.authorization.accessRecovery;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.authorization.AccessRecoveryPage;
import tests.authorization.AuthorizationMainTest;

public class RepeatPasswordByCardTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Восстановление доступа")
    @Story("Доступ по номеру карты. Создание пароля")
    @TmsLink("29910")
    @Test(description = "Повторить пароль. Вход по карте")
    public void repeatPasswordByCardTest() {
        SoftAssert softAssert = new SoftAssert();
        boolean isDisplayAccessRecoveryScreen = loginPageForCard
                .tapOnByCardSection()
                .tapOnForgotPassword()
                .isDisplayAccessRecoveryScreen();
        boolean isDisplayCreatePasswordTittle =
                AccessRecoveryPage.getAccessRecoveryPage()
                .tapOnCardNumberFieldAndInputCard("4301805015601446")
                .tapOnSignInButton()
                .tapOnReadyButtonAfterAccessRecovery()
                .isDisplayCreatePasswordTittle();
        boolean isDisplayConfirmPassTittle =
                AccessRecoveryPage.getAccessRecoveryPage()
                .inputPassword()
                .isDisplayConfirmPasswordTittle();
        AccessRecoveryPage.getAccessRecoveryPage()
                .inputPassword();
        softAssert.assertTrue(isDisplayAccessRecoveryScreen);
        softAssert.assertTrue(isDisplayCreatePasswordTittle);
        softAssert.assertTrue(isDisplayConfirmPassTittle);
        softAssert.assertAll();
    }
}
