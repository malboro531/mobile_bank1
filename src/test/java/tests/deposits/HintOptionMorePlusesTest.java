package tests.deposits;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.depositsAndSavingAccount.deposits.DepositPage;
import pages.android.depositsAndSavingAccount.deposits.OptionConditionsPage;
import pages.android.depositsAndSavingAccount.deposits.RateWithOptionPage;
import tests.AuthWithStandStep;

public class HintOptionMorePlusesTest extends AuthWithStandStep {

    @Epic("Вклады и накопительный счет")
    @Feature("Вклад. Открытие вкладов")
    @Story("Исходящий перевод со счета вклада")
    @TmsLink("32753")
    @Test(description = "Хинт \"Опция \"Больше плюсов\"\" на экране вклада.")
    public void hintOptionMorePlusesOnDepositScreen() {
        SoftAssert softAssert = new SoftAssert();
        var isDisplayDepositScreen = personalCabinetMainPage
                .tapOnShowAllInAccountAndDepositsSection()
                .skipOnboarding()
                .tapOnDepositWithOption()
                .isDisplayDepositScreen();
        softAssert.assertTrue(isDisplayDepositScreen);
        var isDisplayConditions = new DepositPage()
                .tapOnHintInOptionMorePluses()
                .isDisplayOptionsConditionsShower();
        softAssert.assertTrue(isDisplayConditions);
        var isDisplayRateWithOptionScreen = new OptionConditionsPage()
                .tapOnHowRateFormedLink()
                .isDisplayRateWithOptionScreen();
        softAssert.assertTrue(isDisplayRateWithOptionScreen);
        var isDisplayConditionsAfterBackClick = new RateWithOptionPage()
                .tapOnBackButton()
                .isDisplayOptionConditionsShower();
        softAssert.assertTrue(isDisplayConditionsAfterBackClick);
        softAssert.assertAll();
    }
}
