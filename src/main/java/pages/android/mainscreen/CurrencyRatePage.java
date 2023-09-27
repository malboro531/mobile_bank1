package pages.android.mainscreen;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CurrencyRatePage extends AndroidBasePage {
    @AndroidFindBy(id = "cb.ibank:id/view_controller_currency_rates_recycler")
    protected MobileElement CURRENCY_RATES_RECYCLER;


    public boolean isExistCurrencyRatesRecyclerOnPage() {
        return elements.isElementExist(CURRENCY_RATES_RECYCLER);
    }
}
