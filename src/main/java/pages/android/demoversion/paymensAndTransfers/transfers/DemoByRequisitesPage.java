package pages.android.demoversion.paymensAndTransfers.transfers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;
import core.entity.forPages.Requisites;

public class DemoByRequisitesPage extends DemoVersionMainPage {

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Получатель')]")
    protected MobileElement RECIPIENT_NAME;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Счет получателя')]")
    protected MobileElement RECIPIENT_ACCOUNT;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'ИНН')]")
    protected MobileElement INN;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'КПП')]")
    protected MobileElement KPP;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'БИК')]")
    protected MobileElement BIK;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_search_edit_text")
    protected MobileElement BIK_SEARCH_FIELD;
    @AndroidFindBy(xpath = "//android.widget.TextView/..")
    protected MobileElement BIK_FIRST_VARIANT;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'НАЗНАЧЕНИЕ')]/following-sibling::android.widget.EditText")
    protected MobileElement PAYMENT_APPOINTMENT;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Сумма')]")
    protected MobileElement TRANSFER_SUM;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Перевести')]/..")
    protected MobileElement TRANSFER_BUTTON;


    @Step("Заполнить поля")
    public DemoByRequisitesPage fillInFields(Requisites requisites, String bikSearchFieldValue) {
        elements.searchFieldAndSendKey(RECIPIENT_NAME, requisites.getRecipientName());
        elements.searchFieldAndSendKey(RECIPIENT_ACCOUNT, requisites.getRecipientAccount());
        elements.searchFieldAndSendKey(INN, requisites.getINN());
        elements.searchFieldAndSendKey(KPP, requisites.getKPP());
        buttons.searchAndClickButtonBy(BIK);
        elements.searchFieldAndSendKey(BIK_SEARCH_FIELD, bikSearchFieldValue);
        buttons.searchAndClickButtonBy(BIK_FIRST_VARIANT);
        elements.searchFieldAndSendKey(PAYMENT_APPOINTMENT, requisites.getPaymentAppointment());
        screen.scrollablePageAndroidByText(TRANSFER_SUM.getText());
        elements.searchFieldAndSendKey(TRANSFER_SUM, requisites.getTransferSum());
        return this;
    }

    @Step("Тапнуть кнопку 'Перевести'")
    public DemoByRequisitesPage tapOnTransferButton() {
        screen.scrollablePageAndroidByText("Перевести");
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }
}
