package pages.android.paymentsAndTransfers;

import core.base.AndroidBasePage;
import enums.Text;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class BetweenAccountsPage extends AndroidBasePage {

    private static final String CHOOSE_ACCOUNT_FROM = "Выберите счёт списания";
    private static final String CHOOSE_ACCOUNT_RECIPIENT = "Выберите счёт пополнения";

    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_toolbar")
    protected MobileElement TRANSFER_BETWEEN_ACCOUNTS_SCREEN;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_from_title")
    protected MobileElement TRANSFER_TO_ACCOUNT_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_payment_account_amount")
    protected MobileElement PAYMENT_ACCOUNT_AMOUNT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_recipient_title")
    protected MobileElement ACCOUNT_OF_RECIPIENT_TITLE;
    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement SUM_TRANSFER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_from")
    protected MobileElement ACCOUNT_TRANSFER_FROM_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/dialog_payment_choose_option_title")
    protected MobileElement DIALOG_PAYMENT_CHOOSE_ACCOUNT_FROM_TITLE;
    @AndroidFindBy(xpath = "//android.widget.RadioGroup/android.widget.LinearLayout[1]")
    protected MobileElement FIRST_ACCOUNT_VARIANT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_empty_recipient")
    protected MobileElement ACCOUNT_RECIPIENT_CHOOSER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_button_next")
    protected MobileElement TRANSFER_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/dialog_check_payment_requisites_amount")
    protected MobileElement SUM_OF_TRANSFER_DETAILS;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Счёт списания']")
    protected MobileElement DETAILS_ACCOUNT_FROM;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Счёт пополнения']")
    protected MobileElement DETAILS_ACCOUNT_RECIPIENT;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Счёт пополнения']")
    protected MobileElement TYPE_OF_SERVICE_DETAILS;
    @AndroidFindBy(id = "cb.ibank:id/dialog_check_payment_requisites_button_confirm")
    protected MobileElement TRANSFER_CONFIRM_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/payment_finished_create_autopayment")
    protected MobileElement CREATE_AUTOPAYMENT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/payment_finished_receipt")
    protected MobileElement RECEIPT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/payment_finished_favorites")
    protected MobileElement FAVORITES_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/payment_finished_back_to_payment_button")
    protected MobileElement BACK_TO_PAYMENT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_payment_field_hint")
    protected MobileElement PAYMENT_SUM_FIELD_HINT;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Вклад']/ancestor::android.widget.LinearLayout[1]")
    protected MobileElement DEPOSIT_ACCOUNT;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Накопительный счет']/ancestor::android.widget.LinearLayout[1]")
    protected MobileElement SAVING_ACCOUNT;


    @Step("Отображается экран \"перевод между счетами\"\n" +
            "Поля:\n" +
            "1. \"Счёт списания\"\n" +
            "2. \"Счёт пополнения\"\n" +
            "3. \"Сумма\"")
    public boolean isDisplayBetweenAccountsScreen() {
        var isDisplayScreen = elements.isElementExist(TRANSFER_BETWEEN_ACCOUNTS_SCREEN);
        var isDisplayTransferToAccountTitle = elements.isElementExist(TRANSFER_TO_ACCOUNT_TITLE);
        var isDisplayAccountOfRecipientTitle = elements.isElementExist(ACCOUNT_OF_RECIPIENT_TITLE);
        var isDisplaySumTransfer = elements.getTextFromElement(SUM_TRANSFER).equals("Сумма");
        return isDisplayScreen &&
                isDisplayTransferToAccountTitle &&
                isDisplayAccountOfRecipientTitle &&
                isDisplaySumTransfer;
    }

    @Step("Тапнуть на поле \"Счёт списания\"")
    public BetweenAccountsPage tapOnAccountTransferFrom() {
        buttons.searchAndClickButtonBy(ACCOUNT_TRANSFER_FROM_BUTTON);
        return this;
    }

    @Step("Отображается модальное окно\n" +
            "1. Сумма на счету в валюте счета списания\n" +
            "2. Наименование счета (максимальная длина - 1 строка, оставшаяся часть скрыта под “...”)")
    public boolean isExistModalWindowWithTransferFromAccount() {
        return elements
                .getTextFromElement(DIALOG_PAYMENT_CHOOSE_ACCOUNT_FROM_TITLE)
                .equals(CHOOSE_ACCOUNT_FROM);
    }

    @Step("Тапнуть на доступный счёт")
    public BetweenAccountsPage tapOnAvailableAccount() {
        buttons.searchAndClickButtonBy(FIRST_ACCOUNT_VARIANT);
        return this;
    }

    @Step("Тапнуть на \"Счёт пополнения\"")
    public BetweenAccountsPage tapOnAccountRecipient() {
        buttons.searchAndClickButtonBy(ACCOUNT_RECIPIENT_CHOOSER);
        return this;
    }

    @Step("Отображается модальное окно\n" +
            "1. Сумма на счету в валюте счета списания\n" +
            "2. Наименование счета (максимальная длина - 1 строка, оставшаяся часть скрыта под “...”)")
    public boolean isDisplayModalWindowWithTransferForAccountRecipient() {
        return elements
                .getTextFromElement(DIALOG_PAYMENT_CHOOSE_ACCOUNT_FROM_TITLE)
                .equals(CHOOSE_ACCOUNT_RECIPIENT);
    }

    @Step("Тапнуть на доступный счёт для пополнения")
    public BetweenAccountsPage tapOnAvailableAccountForRecipient() {
        buttons.searchAndClickButtonBy(FIRST_ACCOUNT_VARIANT);
        return this;
    }

    @Step("Тапнуть на поле \"Сумма\"\n" +
            "Ввести сумму\n" +
            "Тапнуть на кнопку \"Перевести\"")
    public BetweenAccountsPage tapOnSumFieldAndFillAndTapOnTransferButton(String sum) {
        elements.searchFieldAndSendKey(SUM_TRANSFER, sum);
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }

    @Step("Отображается модальное окно с деталями перевода\n" +
            "1. Сумма\n" +
            "2. Счет списания\n" +
            "3. Счет пополнения\n" +
            "Услуга \"Перевод между счетами\"")
    public boolean isDisplayModalWindowWithTransferDetails(String sum) {
        var isDisplaySum = elements.getTextFromElement(SUM_OF_TRANSFER_DETAILS).equals(sum);
        var isDisplayAccountFrom = elements.isElementExist(DETAILS_ACCOUNT_FROM);
        var isDisplayAccountRecipient = elements.isElementExist(DETAILS_ACCOUNT_RECIPIENT);
        var isDisplayServiceType = elements.isElementExist(TYPE_OF_SERVICE_DETAILS);

        return isDisplaySum &&
                isDisplayAccountFrom &&
                isDisplayAccountRecipient &&
                isDisplayServiceType;
    }

    @Step("Тапнуть на кнопку \"Перевести\" на модалке")
    public BetweenAccountsPage tapOnTransferButtonOnModalWindow() {
        buttons.searchAndClickButtonBy(TRANSFER_CONFIRM_BUTTON);
        waiters.waitForElementClickable(CREATE_AUTOPAYMENT_BUTTON, 30L);
        return this;
    }

    @Step("Отображается экран успеха Кнопки:\n" +
            "\"1. Создать автоплатёж\"\n" +
            "\"2. Получить квитанцию\"\n" +
            "\"3. В избранное\"")
    public boolean isDisplaySuccessScreen() {
        var isDisplayAutoPayment = elements.isElementExist(CREATE_AUTOPAYMENT_BUTTON);
        var isDisplayReceipt = elements.isElementExist(RECEIPT_BUTTON);
        var isDisplayFavorites = elements.isElementExist(FAVORITES_BUTTON);

        return isDisplayAutoPayment && isDisplayReceipt && isDisplayFavorites;
    }

    @Step("Тапнуть на кнопку \"Вернуться в платежи\"")
    public PaymentsAndTransfersPage tapOnBackToPaymentsButton() {
        buttons.searchAndClickButtonBy(BACK_TO_PAYMENT_BUTTON);
        return new PaymentsAndTransfersPage();
    }

    @Step("Тапнуть на поле \"Сумма\"\n" +
            "Ввести сумму больше суммы на счете списания" +
            "Тапнуть на \"Перевести\"")
    public BetweenAccountsPage fillSumFieldOverSumOnAccountTransferFrom() {
        var sumAccount = elements.getTextFromElement(PAYMENT_ACCOUNT_AMOUNT);
        String textForFilling = String.valueOf((parseSumFromAccountToFloat(sumAccount) + 1F));
        elements.searchFieldAndSendKey(SUM_TRANSFER, textForFilling);
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }

    private Float parseSumFromAccountToFloat(String sumAccount) {
        return Float.parseFloat(sumAccount.replaceAll("[^0-9&.]", ""));
    }

    @Step("Отображается модалка \"Необходимо корректно заполнить все поля\" Кнопка \"ОК\"")
    public boolean isDisplayPopUpAboutIncorrectFilling() {
        var textFromMessage = elements.getTextFromElement(COMMON_DIALOG_TEXT);
        var textFromStatic = Text.INVALID_FILLING_FIELDS.getText();

        return textFromMessage.equals(textFromStatic);
    }

    @Step("Тапнуть на кнопку \"ОК\"")
    public BetweenAccountsPage tapOnOkButtonAfterIncorrectFilling() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
        return this;
    }

    @Step("Модальное окно закрылось\n" +
            "Поле \"Сумма\" подсвечивается оранжевым цветом\n" +
            "Хинт в поле \"Сумма\" отображается")
    public boolean isDisplayHintInSumField() {
        return elements.isElementExist(PAYMENT_SUM_FIELD_HINT);
    }

    @Step("Тапом по полю \"Счет списания\" выбрать \"Вклад\" из выпадающего списка")
    public BetweenAccountsPage tapAndChooseDepositAccount() {
        buttons.searchAndClickButtonBy(DEPOSIT_ACCOUNT);
        return this;
    }

    @Step
    public BetweenAccountsPage tapAndChooseSavingAccount() {
        buttons.searchAndClickButtonBy(SAVING_ACCOUNT);
        return this;
    }
}
