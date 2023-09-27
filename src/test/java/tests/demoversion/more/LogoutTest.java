package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends DemoVersionMainTest {

    @Test
    @TmsLink("31897")
    public void logoutTest() {
        var actualResult = demoAccountPage
                .goToMorePage()
                .tapOnLogout()
                .isDisplayStartPage();

        Assert.assertTrue(actualResult);
    }
}
