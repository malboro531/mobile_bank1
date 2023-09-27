package tests.authorization.accessRecovery;

import enums.Text;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.authorization.AccessRecoveryPage;
import steps.autorization.AccessRecoverySteps;
import tests.authorization.AuthorizationMainTest;

public class AlertAbortButtonTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Восстановление доступа")
    @Story("Доступ по номеру карты. Создание пароля")
    @TmsLink("29909")
    @Test(description = "Алерт, кнопка \"Прервать\"")
    public void checkCloseButtonOnAlertAtAccessRecovery() {
        SoftAssert softAssert = new SoftAssert();
        var actualAlertMessage = AccessRecoverySteps
                .goToAccessRecoveryByCard()
                .tapOnCloseButtonAfterAccessRecovery()
                .isDisplayAlertAboutStoppingAccessRecovery();
        var isDisplayStartPage = new AccessRecoveryPage()
                .tapOnAbortButton()
                .isDisplayStartPage();
        softAssert.assertEquals(actualAlertMessage, Text.STOP_ACCESS_RECOVERY_PROCESS.getText());
        softAssert.assertTrue(isDisplayStartPage);
        softAssert.assertAll();
    }
}
