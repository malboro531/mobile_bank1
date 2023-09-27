package pages.android.demoversion.paymensAndTransfers.transfers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.paymensAndTransfers.DemoPaymentsAndTransfersPage;

public class DemoByCardNumberPageDemo extends DemoPaymentsAndTransfersPage {
    @AndroidFindBy(id = "cb.ibank:id/view_transfer_data_field_edit_text")
    protected MobileElement CARD_NUMBER_FIELD;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Сумма')]")
    protected MobileElement TRANSFER_SUM_FIELD;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Комментарий')]")
    protected MobileElement COMMENT_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_by_card_button_next")
    protected MobileElement TRANSFER_BUTTON;


    @Step("Заполнить поля:\n" +
            "Номер карты: '{cardNumber}'\n" +
            "Сумма: '{sum}'\n" +
            "Коментарий: '{comment}'")
    public DemoByCardNumberPageDemo fillInFieldsForTransferByCardNumber(String cardNumber, String sum, String comment) {
        elements.searchFieldAndSendKey(CARD_NUMBER_FIELD, cardNumber);
        elements.searchFieldAndSendKey(TRANSFER_SUM_FIELD, sum);
        elements.searchFieldAndSendKey(COMMENT_FIELD, comment);
        return this;
    }

    @Step("Тапнуть кнопку 'Перевести'")
    public DemoByCardNumberPageDemo tapOnTransferButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }
}
