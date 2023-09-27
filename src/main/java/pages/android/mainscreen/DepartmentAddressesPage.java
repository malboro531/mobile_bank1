package pages.android.mainscreen;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class DepartmentAddressesPage extends AndroidBasePage {
    @AndroidFindBy(accessibility = "Карта")
    protected MobileElement MAP_SELECTOR;
    @AndroidFindBy(accessibility = "Список")
    protected MobileElement LIST_SELECTOR;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Карта Google']/android.view.View[1]")
    protected MobileElement FIRST_VARIANT_DEPARTMENT_ON_MAP;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_addresses_details")
    protected MobileElement ADDITIONAL_INFO_CONTAINER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_addresses_arrow_button")
    protected MobileElement ADDITIONAL_INFO_ARROW_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_addresses_details_view_pager")
    protected MobileElement ADDITIONAL_INFO_PAGER;


    @Step("Открытие вариантов с адресами банкоматов до последнего одиночного варианта")
    public DepartmentAddressesPage goToAddressDepartmentToSingleVariant() {
        while (!elements.isElementExist(ADDITIONAL_INFO_CONTAINER)) {
            buttons.searchAndClickButtonBy(FIRST_VARIANT_DEPARTMENT_ON_MAP);
        }
        return this;
    }

    @Step("Тап на банкомате (развернуть шторку)")
    public DepartmentAddressesPage tapOnArrowButton() {
        buttons.searchAndClickButtonBy(ADDITIONAL_INFO_ARROW_BUTTON);
        return this;
    }

    @Step("Отображается доп. информация в развернутой шторке")
    public boolean isDisplayedAdditionalInfo() {
        return elements.isNotVisibleElement(MAP_SELECTOR);
    }
}
