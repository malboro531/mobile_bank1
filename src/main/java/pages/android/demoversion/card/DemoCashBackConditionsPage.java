package pages.android.demoversion.card;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class DemoCashBackConditionsPage extends DemoCardPage {
    private static final String LABEL_STATUS = "НАЖМИТЕ, ЧТОБЫ ОЗНАКОМИТЬСЯ";

    @AndroidFindBy(id = "cb.ibank:id/view_controller_cashback_container")
    protected MobileElement CASHBACK_PAGE;

    public boolean isDisplayCashBackPage() {
        return elements.isElementExist(CASHBACK_PAGE);
    }
    //TODO проверки
}