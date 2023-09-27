package tests.mainscreen;

import core.base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.mainscreen.CurrencyRatePage;

public class CurrencyRateTest extends BaseTest {
    private final CurrencyRatePage currencyRatePage = new CurrencyRatePage();

    @Test
    @TmsLink("9445")
    public void currencyRates() {
        var actualResult = currencyRatePage
                .goToCurrencyRatesPage()
                .isExistCurrencyRatesRecyclerOnPage();

        Assert.assertTrue(actualResult);
    }
}
