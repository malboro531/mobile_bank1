package tests.demoversion.card;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.demoversion.DemoVersionMainTest;

public class TariffPlanTest extends DemoVersionMainTest {

    @Epic("Демо-режим")
    @Feature("Карты")
    @TmsLink("31854")
    @Test(description = "Тарифный план")
    public void tariffPlanTest() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnTariffPlan()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
