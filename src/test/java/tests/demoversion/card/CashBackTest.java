package tests.demoversion.card;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.demoversion.DemoVersionMainTest;

public class CashBackTest extends DemoVersionMainTest {

    @Test
    @TmsLink("31848")
    public void cashBackDetailConditionsTest() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnDetailsCashBackConditions()
                .isDisplayCashBackPage();

        Assert.assertTrue(actualResult);
    }
}
