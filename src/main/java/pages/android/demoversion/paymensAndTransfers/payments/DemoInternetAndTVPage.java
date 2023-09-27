package pages.android.demoversion.paymensAndTransfers.payments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoInternetAndTVPage extends DemoVersionMainPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Оплата по')]/..")
    protected MobileElement BY_QR_CODE_PAYMENT;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'ПАО')]/..")
    protected MobileElement BY_VENDOR_PAO;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Номер телефона / лицевого счета')]")
    protected MobileElement PHONE_NUMBER_OR_ACCOUNT;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Сумма')]")
    protected MobileElement SUM_FIELD;
    @AndroidFindBy(className = "android.widget.RelativeLayout")
    protected MobileElement NEXT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_search")
    protected MobileElement SEARCH_FIELD_BY_NAME_OR_INN;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_search_edit_text")
    protected MobileElement EDIT_TEXT_FOR_SEARCH;
    @AndroidFindBy(xpath = "//android.widget.TextView/..")
    protected MobileElement FIRST_VENDOR;


    @Step("Тапнуть на кнопку 'Оплата по QR-коду'")
    public DemoInternetAndTVPage tapOnByQRCodePaymentButton() {
        buttons.searchAndClickButtonBy(BY_QR_CODE_PAYMENT);
        return this;
    }

    @Step("Тапнуть на иконку (например 'ПАО 'МТС' HOME [РФ]')")
    public DemoInternetAndTVPage tapOnByVendorPAOButton() {
        buttons.searchAndClickButtonBy(BY_VENDOR_PAO);
        return this;
    }

    @Step("Заполнить поля:" +
            "Номер телефона/лицевого счета: 9923491935" +
            "Сумма: 110.15")
    public DemoInternetAndTVPage fillInFields(String account, String sum) {
        elements.searchFieldAndSendKey(PHONE_NUMBER_OR_ACCOUNT, account);
        elements.searchFieldAndSendKey(SUM_FIELD, sum);
        return this;
    }

    @Step("Тапнуть на кнопку 'Далее'")
    public DemoInternetAndTVPage tapOnNextButton() {
        buttons.searchAndClickButtonBy(NEXT_BUTTON);
        return this;
    }

    @Step("Заполнить поле:" +
            "Поиск по названию или ИНН: 7740000076")
    public DemoInternetAndTVPage fillInFieldByNameOrINN(String inn) {
        buttons.searchAndClickButtonBy(SEARCH_FIELD_BY_NAME_OR_INN);
        elements.searchFieldAndSendKey(EDIT_TEXT_FOR_SEARCH, inn);
        return this;
    }

    @Step("Тапнуть на иконку" +
            "(например 'ПАО 'МТС' HOME [РФ]')")
    public DemoInternetAndTVPage tapOnPAOVendor() {
        buttons.searchAndClickButtonBy(FIRST_VENDOR);
        return this;
    }
}
