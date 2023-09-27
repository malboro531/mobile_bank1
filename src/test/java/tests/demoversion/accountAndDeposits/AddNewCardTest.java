package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCardTest extends DemoVersionMainTest {

    @TmsLink("31840")
    @Test(description = "Пополнить с карты другого банка. Добавить новую карту")
    public void refillWithCardFromOtherBank_AddNewCard() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnFromCardOfOtherBankButton()
                .tapOnTheAddNewCardButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
