package pages.android.demoversion.card.limits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoLimitManagementPage extends DemoVersionMainPage {
    @AndroidFindBy(id = "cb.ibank:id/view_controller_edit_limit_amount")
    protected MobileElement EDIT_LIMIT;
    @AndroidFindBy(id = "cb.ibank:id/edit_quick")
    protected MobileElement READY_BUTTON;
    @AndroidFindBy(accessibility = "Navigate up")
    protected MobileElement BACK_BUTTON;



    @Step()
    public DemoLimitManagementPage editLimitValue(String limitValue) {
        elements.searchFieldAndSendKey(EDIT_LIMIT, limitValue);
        return this;
    }

    @Step("Тапнуть 'Готово'")
    public DemoLimitManagementPage tapOnReadyButton() {
        buttons.searchAndClickButtonBy(READY_BUTTON);
        return this;
    }

    @Step()
    public DemoLimitsPage tapOnBackButton() {
        buttons.searchAndClickButtonBy(BACK_BUTTON);
        return new DemoLimitsPage();
    }
}
