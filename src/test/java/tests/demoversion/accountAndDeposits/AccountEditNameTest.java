package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeSuite;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountEditNameTest extends DemoVersionMainTest {


    @Test
    @TmsLink("31843")
    public void editAccountName() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnEditNameButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
