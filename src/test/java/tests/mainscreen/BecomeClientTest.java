package tests.mainscreen;

import core.base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.mainscreen.BecomeClientPage;

public class BecomeClientTest extends BaseTest {
    private final BecomeClientPage becomeClientPage = new BecomeClientPage();

    @Test
    @TmsLink("29845")
    public void toBecomeClient() {
        var actualResult = becomeClientPage
                .goToBecomeClientPage()
                .isExistBecomeClientContainer();

        Assert.assertTrue(actualResult);
    }
}
