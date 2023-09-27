package pages.android.account;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class AccountPage extends AndroidBasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Реквизиты']/..")
    protected MobileElement REQUISITES_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Открыть карту')]/..")
    protected MobileElement CREATE_CARD_BUTTON;

    @Step("Тапнуть на кнопку \"Реквизиты\"")
    public RequisitesPage tapOnRequisitesButton() {
        waiters.waitForElementClickable(CREATE_CARD_BUTTON);
        buttons.searchAndClickButtonBy(REQUISITES_BUTTON);
        return new RequisitesPage();
    }
}
