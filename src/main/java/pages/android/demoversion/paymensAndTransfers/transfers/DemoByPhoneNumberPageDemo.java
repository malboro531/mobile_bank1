package pages.android.demoversion.paymensAndTransfers.transfers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.paymensAndTransfers.DemoPaymentsAndTransfersPage;

public class DemoByPhoneNumberPageDemo extends DemoPaymentsAndTransfersPage {

    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_by_phone_and_sbp_number_container")
    protected MobileElement PHONE_NUMBER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Перевод в УБРиР')]/..")
    protected MobileElement TRANSFER_TO_UBRIR;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Сумма')]")
    protected MobileElement TRANSFER_SUM;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_by_phone_and_sbp_button_next")
    protected MobileElement TRANSFER_BUTTON;


    @Step("Тапнуть по полю 'Номер телефона'")
    public DemoByPhoneNumberPageDemo tapOnPhoneNumber() {
        buttons.searchAndClickButtonBy(PHONE_NUMBER);
        return this;
    }

    @Step("Тапнуть в разделе 'Получатель' на 'Перевод в УБРиР'")
    public DemoByPhoneNumberPageDemo tapOnRecipientSectionOnUBRiRTransfer() {
        buttons.searchAndClickButtonBy(TRANSFER_TO_UBRIR);
        return this;
    }

    @Step("Ввести в поле 'Сумма' сумму для перевода")
    public DemoByPhoneNumberPageDemo inputSumInFieldForTransfer(String sumForTransfer) {
        elements.searchFieldAndSendKey(TRANSFER_SUM, sumForTransfer);
        return this;
    }

    @Step("Тапнуть на 'Перевести'")
    public DemoByPhoneNumberPageDemo tapOnTransferButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }
}
