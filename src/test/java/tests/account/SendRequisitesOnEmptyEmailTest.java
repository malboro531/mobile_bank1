package tests.account;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.account.RequisitesPage;
import steps.autorization.LoginByPANSteps;

public class SendRequisitesOnEmptyEmailTest extends LoginByPANSteps {

    @Epic("Счет")
    @Feature("Отправка/Сохранение реквизитов")
    @TmsLink("21820")
    @Test(description = "Отправка реквизитов на пустой Email. Хинт")
    public void sendingRequisitesOnEmptyEmailAndHintWorkingTest() {
        SoftAssert softAssert = new SoftAssert();
        var requisitesPage = new RequisitesPage();
        var isDisplayAboutEmpty = personalCabinetMainPage
                .tapOnAccountInBlock()
                .tapOnRequisitesButton()
                .tapOnSaveOrShareButton()
                .tapOnSendToEmail()
                .tapOnSendButton()
                .isDisplayMessageAboutFieldEmpty();
        softAssert.assertTrue(isDisplayAboutEmpty);
        var isDisplayQuestionIcon = requisitesPage
                .tapOnOkButton()
                .isDisplayQuestionIcon();
        softAssert.assertTrue(isDisplayQuestionIcon);
        var isDisplayMessageEmpty = requisitesPage
                .tapOnHintInFieldForInput()
                .isDisplayMessageAboutFieldEmpty();
        softAssert.assertTrue(isDisplayMessageEmpty);
        var isDisplayWithInvalidDataScreen = requisitesPage
                .tapOnOkButton()
                .isDisplayQuestionIcon();
        softAssert.assertTrue(isDisplayWithInvalidDataScreen);
        softAssert.assertAll();
    }
}
