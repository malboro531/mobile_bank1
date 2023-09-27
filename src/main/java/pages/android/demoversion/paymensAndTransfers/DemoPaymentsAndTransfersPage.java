package pages.android.demoversion.paymensAndTransfers;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.paymensAndTransfers.payments.DemoInternetAndTVPage;
import pages.android.demoversion.paymensAndTransfers.payments.DemoMobileConnectionPage;
import pages.android.demoversion.paymensAndTransfers.transfers.*;

public class DemoPaymentsAndTransfersPage extends DemoVersionMainPage {
    private final Point paymentsPoint = screen.setPointForSwipe(1.25F, 2F);

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'По номеру телефона')]/..")
    protected MobileElement BY_PHONE_NUMBER_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Между счетами')]/..")
    protected MobileElement BETWEEN_ACCOUNTS;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'По номеру карты')]/..")
    protected MobileElement BY_CARD_NUMBER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'По реквизитам счёта')]/..")
    protected MobileElement BY_REQUISITES;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'СБП')]/..")
    protected MobileElement SYSTEM_OF_FAST_PAYMENTS;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Оплата по QR-коду')]/..")
    protected MobileElement BY_QR_CODE;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Мобильная связь')]/..")
    protected MobileElement MOBILE_CONNECTION;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Оплата услуг ЖКХ')]/..")
    protected MobileElement PAYMENT_OF_UTILITY_SERVICES;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Домашний телефон')]/..")
    protected MobileElement HOME_PHONE;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Интернет и ТВ')]/..")
    protected MobileElement INTERNET_AND_TV_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Образование')]/..")
    protected MobileElement EDUCATION_BUTTON;


    @Step("Тапнуть на 'По номеру телефона' в разделе 'Переводы'")
    public DemoByPhoneNumberPageDemo tapOnByPhoneNumberButton() {
        buttons.searchAndClickButtonBy(BY_PHONE_NUMBER_BUTTON);
        return new DemoByPhoneNumberPageDemo();
    }

    @Step("Тапнуть на кнопку 'Между счетами'")
    public DemoBetweenAccountsPageDemo tapOnBetweenAccountsButton() {
        buttons.searchAndClickButtonBy(BETWEEN_ACCOUNTS);
        return new DemoBetweenAccountsPageDemo();
    }

    @Step("Тапнуть кнопку 'По номеру карты'")
    public DemoByCardNumberPageDemo tapOnByCardNumberButton() {
        buttons.searchAndClickButtonBy(BY_CARD_NUMBER);
        return new DemoByCardNumberPageDemo();
    }

    @Step("Тапнуть кнопку 'По реквизитам'")
    public DemoByRequisitesPage tapOnByRequisitesButton() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 1000, null);
        buttons.searchAndClickButtonBy(BY_REQUISITES);
        return new DemoByRequisitesPage();
    }

    @Step("Тапнуть кнопку 'СБП'")
    public DemoPaymentsAndTransfersPage tapOnSBPButton() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 1000, null);
        buttons.searchAndClickButtonBy(SYSTEM_OF_FAST_PAYMENTS);
        return this;
    }

    @Step("Тапнуть кнопку 'По номеру телефона'")
    public DemoSystemOfFastPaymentsPage tapOnByPhoneNumberButtonThroughSBP() {
        buttons.searchAndClickButtonBy(BY_PHONE_NUMBER_BUTTON);
        return new DemoSystemOfFastPaymentsPage();
    }

    @Step("Тапнуть на кнопку 'Оплата по QR-коду'")
    public DemoPaymentsAndTransfersPage tapOnPaymentByQRCodeButton() {
        buttons.searchAndClickButtonBy(BY_QR_CODE);
        return this;
    }

    @Step("Тапнуть кнопку 'Мобильная связь'")
    public DemoMobileConnectionPage tapOnMobileConnectionButton() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 800, paymentsPoint);
        buttons.searchAndClickButtonBy(MOBILE_CONNECTION);
        return new DemoMobileConnectionPage();
    }

    @Step("Тапнуть кнопку 'Оплата услуг ЖКХ'")
    public DemoPaymentsAndTransfersPage tapOnPaymentOfUtilityServices() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 200, paymentsPoint);
        buttons.searchAndClickButtonBy(PAYMENT_OF_UTILITY_SERVICES);
        return this;
    }

    @Step("Тапнуть на кнопку 'Домашний телефон'")
    public DemoPaymentsAndTransfersPage tapOnHomePhoneButton() {
        buttons.searchAndClickButtonBy(HOME_PHONE);
        return this;
    }

    @Step("Тапнуть на кнопку 'Интернет и ТВ'")
    public DemoInternetAndTVPage tapOnInternetAndTVButton() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 200, paymentsPoint);
        buttons.searchAndClickButtonBy(INTERNET_AND_TV_BUTTON);
        return new DemoInternetAndTVPage();
    }

    @Step("Тапнуть на кнопку 'Образование'")
    public DemoPaymentsAndTransfersPage tapOnEducationButton() {
        buttons.searchAndClickButtonBy(EDUCATION_BUTTON);
        return this;
    }
}