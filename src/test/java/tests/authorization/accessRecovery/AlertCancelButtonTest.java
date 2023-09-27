package tests.authorization.accessRecovery;

import enums.Text;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.authorization.AccessRecoveryPage;
import steps.autorization.AccessRecoverySteps;
import tests.authorization.AuthorizationMainTest;

public class AlertCancelButtonTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Восстановление доступа")
    @Story("Доступ по номеру карты. Создание пароля")
    @TmsLinks({
            @TmsLink("29907"),
            @TmsLink("29908")
    })
    @Test(description = "Алерт: Кнопка закрыть / Кнопка отмена")
    public void checkCloseButtonOnAlertAtAccessRecovery() {
        SoftAssert softAssert = new SoftAssert();
        var actualAlertMessage = AccessRecoverySteps
                .goToAccessRecoveryByCard()
                .tapOnCloseButtonAfterAccessRecovery()
                .isDisplayAlertAboutStoppingAccessRecovery();
        var isDisplayPasswordCreatingScreen = new AccessRecoveryPage()
                .tapOnCancelButton()
                .isDisplayCreatingPasswordScreen();
        softAssert.assertEquals(actualAlertMessage, Text.STOP_ACCESS_RECOVERY_PROCESS.getText());
        softAssert.assertTrue(isDisplayPasswordCreatingScreen);
        softAssert.assertAll();
    }
}
