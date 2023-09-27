package pages.android.demoversion.accountsAndDeposits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.card.DemoCardPage;

import static core.InitialDriver.getAndroidDriver;

public class DemoAccountPage extends DemoVersionMainPage {
    private static final String SALARY_ACCOUNT_NAME = "Зарплатный счет";
    private static final String CERTIFICATE_AVAILABLE_RESIDUE_TEXT = "Справка о доступном остатке";

    @AndroidFindBy(accessibility = "Переименовать")
    protected MobileElement EDIT_NAME_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView[contains(@text, 'Пополнить')]/..")
    protected MobileElement ACCOUNT_REFILL_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.TextView[contains(@text, 'Реквизиты')]/..")
    protected MobileElement REQUISITES_BUTTON;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[contains(@text, '3457')]/..")
    protected MobileElement CARD_WITHOUT_PIN_CODE;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Со своего счёта')]")
    protected MobileElement FROM_MY_ACCOUNT_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'С карты другого банка')]")
    protected MobileElement FROM_CARD_OTHER_BANK;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Запросить платеж')]")
    protected MobileElement REQUEST_PAYMENT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_recipient")
    protected MobileElement TRANSFER_TO_ACCOUNT_RECIPIENT;
    @AndroidFindBy(id = "cb.ibank:id/view_payment_account_name")
    protected MobileElement PAYMENT_ACCOUNT_NAME;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_empty_sender")
    protected MobileElement TRANSFER_FROM_ACCOUNT_SENDER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Накопительный счет')]/..")
    protected MobileElement DEPOSIT_ACCOUNT_VARIANT_TRANSFER;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.EditText")
    protected MobileElement SUM_OF_TRANSFER_EDITTEXT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_button_next")
    protected MobileElement TRANSFER_BUTTON;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    protected MobileElement CARD_WITH_PIN_CODE;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '" + CERTIFICATE_AVAILABLE_RESIDUE_TEXT + "')]/..")
    protected MobileElement CERTIFICATE_AVAILABLE_RESIDUE;



    // Возвращает карту по последним 4 цифрам
    private MobileElement getCard(String cardNumber){
        String cardXpath = String.format("//android.widget.TextView[contains(@text, '%s')]/..", cardNumber);
        return getAndroidDriver().findElement(By.xpath(cardXpath));
    }

    @Step("Тапнуть на карте с номером {cardNumber}")
    public DemoCardPage tapOnCardWithNumber(String cardNumber) {
        buttons.searchAndClickButtonBy(getCard(cardNumber));
        return new DemoCardPage();
    }

    @Step("Тапнуть на кнопку 'Переименовать'")
    public DemoAccountPage tapOnEditNameButton() {
        buttons.searchAndClickButtonBy(EDIT_NAME_BUTTON);
        return this;
    }

    @Step("Тапнуть на кнопку 'Пополнить'")
    public DemoAccountPage tapOnRefillButton() {
        buttons.searchAndClickButtonBy(ACCOUNT_REFILL_BUTTON);
        return this;
    }

    @Step("Тапнуть 'Реквизиты'")
    public DemoRequisitesPage tapOnRequisites() {
        buttons.searchAndClickButtonBy(REQUISITES_BUTTON);
        return new DemoRequisitesPage();
    }

    @Step("Тапнуть на 'Карту' последнюю карту с номером *3457")
    public DemoCardPage tapOnCardWithoutPinCode() {
        buttons.searchAndClickButtonBy(CARD_WITHOUT_PIN_CODE);
        return new DemoCardPage();
    }

    @Step("Тапнуть на опцию 'Со своего счета'")
    public DemoAccountPage tapOnFromMyAccountButton() {
        buttons.searchAndClickButtonBy(FROM_MY_ACCOUNT_BUTTON);
        return this;
    }

    @Step("Тапнуть на опцию 'С карты другого банка'")
    public DemoChooseCardPage tapOnFromCardOfOtherBankButton() {
        buttons.searchAndClickButtonBy(FROM_CARD_OTHER_BANK);
        return new DemoChooseCardPage();
    }

    @Step("Тапнуть на опцию 'Запросить платеж'")
    public DemoAccountPage tapOnRequestPaymentButton() {
        buttons.searchAndClickButtonBy(REQUEST_PAYMENT);
        return this;
    }

    @Step("В поле 'Счет пополнения' указан выбранный ранее счет")
    public boolean isExistSelectedAccount() {
        return elements.getTextFromElement(PAYMENT_ACCOUNT_NAME).equals(SALARY_ACCOUNT_NAME);
    }

    @Step("Тапнуть на поле с плейсхолдером 'Выбрать счёт списания'")
    public DemoAccountPage tapOnTransferFromAccountSender() {
        buttons.searchAndClickButtonBy(TRANSFER_FROM_ACCOUNT_SENDER);
        return this;
    }

    @Step("Выбрать счет 'Накопительный счет'")
    public DemoAccountPage chooseDepositAccountCheckbox() {
        buttons.searchAndClickButtonBy(DEPOSIT_ACCOUNT_VARIANT_TRANSFER);
        return this;
    }

    @Step("Ввести сумму в поле с плейсхолдером 'Сумма'")
    public DemoAccountPage inputSumForTransfer(String sumOfTransfer) {
        buttons.searchAndClickButtonBy(SUM_OF_TRANSFER_EDITTEXT);
        elements.sendKeyFromAction(sumOfTransfer);
        return this;
    }

    @Step("Тапнуть на кнопку 'Перевести'")
    public DemoAccountPage tapOnTransferButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }

    @Step("Тапнуть на первую карту с номером *3438")
    public DemoCardPage tapOnCardWithPinCode() {
        buttons.searchAndClickButtonBy(CARD_WITH_PIN_CODE);
        return new DemoCardPage();
    }

    @Step("Тапнуть на опцию '" + CERTIFICATE_AVAILABLE_RESIDUE_TEXT + "'")
    public DemoCertificateAvailableResiduePage tapOnCertificateAvailableResidue() {
        screen.scrollablePageAndroidByText(CERTIFICATE_AVAILABLE_RESIDUE_TEXT);
        buttons.searchAndClickButtonBy(CERTIFICATE_AVAILABLE_RESIDUE);
        return new DemoCertificateAvailableResiduePage();
    }
}
