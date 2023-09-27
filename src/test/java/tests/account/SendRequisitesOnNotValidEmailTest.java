package tests.account;

import core.base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.account.RequisitesPage;

public class SendRequisitesOnNotValidEmailTest extends BaseTest {

    @Epic("Счет")
    @Feature("Отправка/Сохранение реквизитов")
    @TmsLink("21913")
    @Test(description = "Отправка реквизитов счета на не валидный Email. Нет привязанной почты")
    public void sendingRequisitesOfAccountToEmailNotValidAndNotExistEmail() {
        var actualResult = personalCabinetMainPage
                .tapOnAccountInBlock()
                .tapOnRequisitesButton()
                .tapOnSaveOrShareButton()
                .tapOnSendToEmail()
                .inputIncorrectEmailInFieldAndClickOnEnter("aiaosdaoisjdasd")
                .isDisplayQuestionIcon();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void isExistMessageAboutIncorrectEmail() {
        var actualResult = new RequisitesPage()
                .tapOnSendButton()
                .isDisplayMessageAboutIncorrectEmail();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 2)
    public void isDisplayQuestionIconAgain() {
        var actualResult = new RequisitesPage()
                .tapOnOkButton()
                .isDisplayQuestionIcon();

        Assert.assertTrue(actualResult);
    }




}
