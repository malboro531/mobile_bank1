package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyRateTest extends MoreMainTest {

    @Test
    @TmsLink("24529")
    public void currencyRateTest() {
        var actualResult = demoMorePage
                .tapOnCurrencyRates()
                .isExistCurrencyRatesRecyclerOnPage();

        Assert.assertTrue(actualResult);
    }
}
