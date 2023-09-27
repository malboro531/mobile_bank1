package core.base;

import elements.Buttons;
import elements.Elements;
import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.android.authorization.LoginPageForLogin;
import pages.android.demoversion.accountsAndDeposits.DemoAccountPage;
import pages.android.mainscreen.BecomeClientPage;
import pages.android.mainscreen.CurrencyRatePage;
import pages.android.mainscreen.DepartmentAddressesPage;
import utils.mobile.Waiters;

import static core.InitialDriver.getAndroidDriver;
import static pages.android.authorization.LoginPageForLogin.getLoginPageForLogin;
import static utils.mobile.Waiters.getWaiters;

public class AndroidBasePage {
    private final AndroidDriver<MobileElement> androidDriver;
    protected Buttons buttons;
    protected Screen screen;
    protected Elements elements;
    protected Waiters waiters;

    public AndroidBasePage() {
        this.androidDriver = getAndroidDriver();
        waiters = getWaiters();
        buttons = new Buttons(androidDriver, waiters);
        screen = new Screen(androidDriver, waiters);
        elements = new Elements(androidDriver, waiters);

        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(accessibility = "Перейти вверх")
    protected MobileElement BACK_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_button_login")
    protected MobileElement LOGIN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_button_become_client")
    protected MobileElement BECOME_CLIENT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/include_department_addresses")
    protected MobileElement DEPARTMENT_ADDRESSES_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/include_currency_rates")
    protected MobileElement CURRENCY_RATES_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_demo_version")
    protected MobileElement DEMO_VERSION_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_title")
    protected MobileElement WELCOME_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    protected MobileElement COMMON_DIALOG_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_ok")
    protected MobileElement OK_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_cancel")
    protected MobileElement CANCEL_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/tutorial_view_title")
    protected MobileElement ONBOARDING_TITLE_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/tutorial_view_message")
    protected MobileElement ONBOARDING_MESSAGE_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/tutorial_view_next_button")
    protected MobileElement ONBOARDING_NEXT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_test_settings")
    protected MobileElement TEST_SETTINGS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_test_settings_api_endpoints")
    protected MobileElement API_ENDPOINTS_BUTTON;

    @Step("Тапнуть на кнопку 'Курс валют'")
    public CurrencyRatePage goToCurrencyRatesPage() {
        buttons.waitInSecondsAndClickButtonBy(CURRENCY_RATES_BUTTON, 3);
        return new CurrencyRatePage();
    }

    @Step("Тапнуть на кнопку 'Адреса'")
    public DepartmentAddressesPage goToDepartmentAddressesPage() {
        buttons.searchAndClickButtonBy(DEPARTMENT_ADDRESSES_BUTTON);
        return new DepartmentAddressesPage();
    }

    @Step("Тапнуть на блок Стать клиентом")
    public BecomeClientPage goToBecomeClientPage() {
        buttons.searchAndClickButtonBy(BECOME_CLIENT_BUTTON);
        return new BecomeClientPage();
    }

    @Step("Тап на кнопку 'Войти'")
    public LoginPageForLogin goToSignInPage() {
        buttons.searchAndClickButtonBy(LOGIN_BUTTON);
        return getLoginPageForLogin().isDisplaySignInScreenAndSectionsForLogin();
    }

    @Step("Тапнуть на кнопку 'Демо-версия'")
    public DemoAccountPage goToDemoVersion() {
        buttons.searchAndClickButtonBy(DEMO_VERSION_BUTTON);
        return new DemoAccountPage();
    }

    public void tapOnTestSettingsButtonAndChooseStand(String standName) {
        buttons.searchAndClickButtonBy(TEST_SETTINGS_BUTTON);
        buttons.searchAndClickButtonBy(API_ENDPOINTS_BUTTON);
        chooseAndTapStandForTest(standName);
        buttons.searchAndClickButtonBy(BACK_BUTTON);
    }

    private void chooseAndTapStandForTest(String standName) {
        var standVariantElement = androidDriver.findElementByXPath("//android.widget.CheckedTextView[@text='" + standName + "']");
        buttons.searchAndClickButtonBy(standVariantElement);
    }

    public boolean isDisplayStartPage() {
        return elements.isElementExist(WELCOME_TITLE);
    }


}
