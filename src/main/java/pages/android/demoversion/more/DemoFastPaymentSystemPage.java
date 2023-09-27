package pages.android.demoversion.more;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoFastPaymentSystemPage extends DemoVersionMainPage {

    private static final String TITLE_TEXT = "Счёт для получения переводов";
    @AndroidFindBy(id = "cb.ibank:id/show_info")
    protected MobileElement SHOW_INFO_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sbp_info_button_close")
    protected MobileElement SBP_INFO_CLOSE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sbp_settings_phone_view")
    protected MobileElement SBP_SETTINGS_PHONE_SELECTOR;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    protected MobileElement OTHER_PHONE_NUMBER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sbp_settings_account_hint")
    protected MobileElement SBP_SETTINGS_ACCOUNT_HINT;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    protected MobileElement SBP_OK_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_title")
    protected MobileElement TITLE_FROM_ALERT_ACCOUNT_FOR_GET_TRANSFER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sbp_settings_check_box_agreement")
    protected MobileElement AGREE_CONDITIONS_SBP_CHECKBOX;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sbp_settings_button_connect")
    protected MobileElement CONNECT_BUTTON;

    @Step("Тапнуть на хинт 'о СБП'")
    public DemoFastPaymentSystemPage tapOnHintAboutFastPaymentSystem() {
        buttons.searchAndClickButtonBy(SHOW_INFO_BUTTON);
        return this;
    }

    @Step("Тапнуть 'Закрыть'")
    public DemoFastPaymentSystemPage tapOnCloseButton() {
        buttons.searchAndClickButtonBy(SBP_INFO_CLOSE_BUTTON);
        return this;
    }

    @Step("Тапнуть на поле 'Мобильный телефон'")
    public DemoFastPaymentSystemPage tapOnPhoneField() {
        buttons.searchAndClickButtonBy(SBP_SETTINGS_PHONE_SELECTOR);
        return this;
    }

    @Step("Тапнуть на другой номер")
    public DemoFastPaymentSystemPage tapOnOtherNumber() {
        buttons.searchAndClickButtonBy(OTHER_PHONE_NUMBER);
        return this;
    }

    @Step("Тапнуть на хинт в поле 'Счет для получения переводов'")
    public DemoFastPaymentSystemPage tapOnSPBSettingsAccountHint() {
        buttons.searchAndClickButtonBy(SBP_SETTINGS_ACCOUNT_HINT);
        return this;
    }

    @Step("Отображается информация о 'счете для получения перевода'")
    public boolean isDisplayedInfoText() {
        var titleText = elements.getTextFromElement(TITLE_FROM_ALERT_ACCOUNT_FOR_GET_TRANSFER);
        return titleText.equals(TITLE_TEXT);
    }

    @Step("Тапнуть 'ОК'")
    public DemoFastPaymentSystemPage tapOnOkButtonAndGoToSBP() {
        buttons.searchAndClickButtonBy(SBP_OK_BUTTON);
        return this;
    }

    @Step("Тапнуть на чек-бокс 'Об обработке персональных данных'")
    public DemoFastPaymentSystemPage tapOnAgreeConditionsCheckbox() {
        buttons.searchAndClickButtonBy(AGREE_CONDITIONS_SBP_CHECKBOX);
        return this;
    }

    @Step("Тапнуть 'подключится'")
    public DemoFastPaymentSystemPage tapOnConnectButton() {
        buttons.searchAndClickButtonBy(CONNECT_BUTTON);
        return this;
    }
}
