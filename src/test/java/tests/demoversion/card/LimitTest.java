package tests.demoversion.card;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.demoversion.card.limits.DemoLimitManagementPage;
import tests.demoversion.DemoVersionMainTest;

import static pages.android.demoversion.card.limits.DemoLimitsPage.LIMITS_TYPE;


public class LimitTest extends DemoVersionMainTest {

    private final SoftAssert softAssert = new SoftAssert();
    private final String editSum = "2500";
    private final String cardNumber = "3492";
    private DemoLimitManagementPage demoLimitManagement;

    @TmsLink("31849")
    @Test
    public void limitTest() {
        demoLimitManagement = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithNumber(cardNumber)
                .tapOnLimitsButton()
                .tapOnAllExpensesPerMonthButton()
                .editLimitValue(editSum)
                .tapOnReadyButton();

        softAssert.assertTrue(demoLimitManagement
                        .isExistAlertAboutNotAvailableInDemoVersionAndTapOK()
                , "При редактирвоание лимитов 'Все расходы в месяц' не появилось сообщение  'Недоступно в демо-режиме'");

        editLimit(LIMITS_TYPE.INTERNET_TRANSACTIONS_PER_DAY);
        editLimit(LIMITS_TYPE.SPENDING_ABROAD_PER_DAY);
        editLimit(LIMITS_TYPE.ALL_EXPENSES_PER_DAY);
        editLimit(LIMITS_TYPE.CASH_WITH_PER_DAY);
    }

    void editLimit(LIMITS_TYPE key) {
        softAssert.assertTrue(
                demoLimitManagement.
                        tapOnBackButton()
                        .tapOnAddLimitButton()
                        .tapOnCash(key, key.getName())
                        .editLimitValue(editSum)
                        .tapOnReadyButton()
                        .isExistAlertAboutNotAvailableInDemoVersionAndTapOK()
                , String.format(
                        "При редактирвоание лимитов '%s' не появилось сообщение  'Недоступно в демо-режиме'",
                        key.getName()));
    }
}
