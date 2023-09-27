package tests.demoversion.card;

import io.qameta.allure.TmsLink;
import pages.android.demoversion.card.DemoCardPage;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditPinCodeTest extends DemoVersionMainTest {

    @Test
    @TmsLink("31851")
    public void editPinCodeForCardWithCode() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnEditPinCode()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        var isDisplayActionsBlock = new DemoCardPage().isDisplayActionsBlock();
        Assert.assertTrue(actualResult && isDisplayActionsBlock);
    }
}
