package pages.android.demoversion.more;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoDepartmentAddressesPage extends DemoVersionMainPage {

    @AndroidFindBy(id = "cb.ibank:id/view_controller_addresses_view_pager")
    protected MobileElement MAP_PAGER;
    @AndroidFindBy(accessibility = "Список")
    protected MobileElement LIST_ADDRESSES_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_atm_list_recycler_view")
    protected MobileElement LIST_OF_ADDRESSES;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_atm_map_zoom_in_button")
    protected MobileElement ZOOM_IN_BUTTON;

    @Step("В подразделе 'Карта' отображается карта города")
    public boolean isDisplayMapCity() {
        waiters.waitForVisibility(ZOOM_IN_BUTTON);
        return elements.isElementExist(MAP_PAGER);
    }

    @Step("Тапнуть на 'Список'")
    public DemoDepartmentAddressesPage tapOnListOfAddresses() {
        buttons.searchAndClickButtonBy(LIST_ADDRESSES_BUTTON);
        return this;
    }

    @Step("Отображается список банкоматов")
    public boolean isDisplayListOfAddresses() {
        return elements.isElementExist(LIST_OF_ADDRESSES);
    }
}
