package pages.android.paymentsAndTransfers;

import config.PropertiesConfig;
import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class PaymentsAndTransfersPage extends AndroidBasePage {

    @AndroidFindBy(id = "cb.ibank:id/item_edit_quick_payment_container")
    protected MobileElement EDIT_PAYMENTS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_root")
    protected MobileElement PAYMENTS_SCREEN;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_transfer_recycler_view")
    protected MobileElement TRANSFERS_BLOCK;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_payments_category_recycler_view")
    protected MobileElement PAYMENTS_BLOCK;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Между счетами']/..")
    protected MobileElement PAYMENT_BETWEEN_ACCOUNTS;


    @Step("Отображается подсказка \"Быстрые платежи\" с текстом:\n" +
            "\"Все успешно выполненные операции временно сохраняются в меню быстрых платежей. " +
            "По нажатию на ярлык быстрого платежа можно перейти к оплате без необходимости заполнять данные заново.\"")
    public boolean isDisplayOnboardingAboutFastPayment() {
        var textFromMessage = elements.getTextFromElement(ONBOARDING_MESSAGE_TEXT);
        var textFromTitle = elements.getTextFromElement(ONBOARDING_TITLE_TEXT);

        return isEqualsTextFromOnboardingAndFromProperties(textFromTitle, "FAST_PAYMENTS_TITLE_TEXT") &&
        isEqualsTextFromOnboardingAndFromProperties(textFromMessage, "FAST_PAYMENT_MESSAGE_TEXT");
    }

    @Step("Тапнуть на кнопку \"Далее\"")
    public PaymentsAndTransfersPage tapOnNextAfterFastPaymentOnboardingButton() {
        buttons.searchAndClickButtonBy(ONBOARDING_NEXT_BUTTON);
        return this;
    }

    @Step("Подсвечивается секция Платежи\n" +
            "Отображается подсказка \"Как оплачивать по QR-коду\" напротив иконки \"Оплата по QR-коду\" с текстом:\n" +
            "\"Отсканируйте его на квитанции ЖКХ или другом счете, и мы сами заполним все данные. " +
            "Либо воспользуйтесь функцией сканирования из файла, если ваша квитанция сохранена в фотогалереи.\"")
    public boolean isDisplayOnboardingAboutPaymentsByQRCode() {
        var textFromMessage = elements.getTextFromElement(ONBOARDING_MESSAGE_TEXT);
        var textFromTitle = elements.getTextFromElement(ONBOARDING_TITLE_TEXT);

        return isEqualsTextFromOnboardingAndFromProperties(textFromTitle, "PAYMENT_BY_QR_CODE_TITLE") &&
                isEqualsTextFromOnboardingAndFromProperties(textFromMessage, "PAYMENT_BY_QR_CODE_MESSAGE");
    }

    private boolean isEqualsTextFromOnboardingAndFromProperties(String textFromOnboarding, String nameFromProperty) {
        return textFromOnboarding.equals(PropertiesConfig.getProperty(nameFromProperty));
    }

    @Step("Тапнуть на кнопку \"Понятно\"")
    public PaymentsAndTransfersPage tapOnNextPaymentByQRCodeOnboardingButton() {
        buttons.searchAndClickButtonBy(ONBOARDING_NEXT_BUTTON);
        return this;
    }

    @Step("Экран Платежи и переводы отображается с разделами:\n" +
            "1. Переводы\n" +
            "2. Платежи")
    public boolean isDisplayPaymentsScreenWithSections() {
        var isDisplayScreen = elements.isElementExist(PAYMENTS_SCREEN);
        var isDisplayTransfersBlock = elements.isElementExist(TRANSFERS_BLOCK);
        var isDisplayPaymentsBlock = elements.isElementExist(PAYMENTS_BLOCK);

        return isDisplayScreen && isDisplayPaymentsBlock && isDisplayTransfersBlock;
    }

    @Step("Тапнуть на иконку \"Между счетами\"")
    public BetweenAccountsPage tapOnBetweenAccountsIcon() {
        buttons.searchAndClickButtonBy(PAYMENT_BETWEEN_ACCOUNTS);
        return new BetweenAccountsPage();
    }
}
