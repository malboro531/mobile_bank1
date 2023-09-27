package tests.demoversion.card;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.card.DemoCardPage;
import tests.demoversion.DemoVersionMainTest;

public class SetPinCodeTest extends DemoVersionMainTest {

    @Test
    @TmsLink("31850")
    public void setPinCodeOnCardTest() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithoutPinCode()
                .scrollToActionsBlock()
                .tapOnSetPinCodeButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        var isDisplayActionsBlock = new DemoCardPage().isDisplayActionsBlock();
        Assert.assertTrue(actualResult && isDisplayActionsBlock);
    }
}
