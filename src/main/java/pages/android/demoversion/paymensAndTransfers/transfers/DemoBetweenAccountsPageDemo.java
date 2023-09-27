package pages.android.demoversion.paymensAndTransfers.transfers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.paymensAndTransfers.DemoPaymentsAndTransfersPage;

public class DemoBetweenAccountsPageDemo extends DemoPaymentsAndTransfersPage {

    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_empty_recipient")
    protected MobileElement REFILL_ACCOUNT;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Накопительный счет')]/ancestor::android.widget.LinearLayout[1]")
    protected MobileElement DEPOSIT_ACCOUNT_VARIANT;
    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement TRANSFER_SUM;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_button_next")
    protected MobileElement TRANSFER_BUTTON;


    @Step("Заполнить поля:\n" +
            "Счет пополнения: 'Накопительный'\n" +
            "Сумма: {sum}"
    )
    public DemoBetweenAccountsPageDemo fillInFields(String sum) {
        buttons.searchAndClickButtonBy(REFILL_ACCOUNT);
        buttons.searchAndClickButtonBy(DEPOSIT_ACCOUNT_VARIANT);
        elements.searchFieldAndSendKey(TRANSFER_SUM, sum);
        return this;
    }

    @Step("Тапнуть кнопку 'Перевести'")
    public DemoBetweenAccountsPageDemo tapOnTransferButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }

}
