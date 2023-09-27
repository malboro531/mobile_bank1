package pages.android.account;

import core.base.AndroidBasePage;
import enums.Text;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import static core.InitialDriver.getAndroidDriver;

public class RequisitesPage extends AndroidBasePage {

    private static final String INCORRECT_EMAIL_MESSAGE_TEXT = "Введен некорректный\nEmail адрес";
    @AndroidFindBy(id = "cb.ibank:id/view_controller_requisites_root")
    protected MobileElement REQUISITES_SCREEN;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_requisites_progress_button")
    protected MobileElement SAVE_OR_SHARE_REQUISITES_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/credit_contract_send_to_email_button")
    protected MobileElement SEND_TO_EMAIL;
    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement EMAIL_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_send_to_email_send_button")
    protected MobileElement SEND_REQUISITE_TO_EMAIL_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_payment_field_hint")
    protected MobileElement VIEW_PAYMENT_FIELD_HINT;


    @Step("Тапнуть на кнопку \"Сохранить или переслать\"")
    public RequisitesPage tapOnSaveOrShareButton() {
        buttons.searchAndClickButtonBy(SAVE_OR_SHARE_REQUISITES_BUTTON);
        return this;
    }

    @Step("Тап на \"Отправить на email\"")
    public RequisitesPage tapOnSendToEmail() {
        buttons.searchAndClickButtonBy(SEND_TO_EMAIL);
        return this;
    }

    @Step("Ввести некорректный email в поле ввода. Нажать \"Ввод\" на клавиатуре")
    public RequisitesPage inputIncorrectEmailInFieldAndClickOnEnter(String incorrectEmail) {
        elements.searchFieldAndSendKey(EMAIL_FIELD, incorrectEmail);
        getAndroidDriver().hideKeyboard();
        return this;
    }

    @Step("Значок \"Вопроса\" отображается конце поля ввода \"Email\"")
    public boolean isDisplayQuestionIcon() {
        return elements.isElementExist(VIEW_PAYMENT_FIELD_HINT);
    }

    @Step("Тап по кнопке \"Отправить\"")
    public RequisitesPage tapOnSendButton() {
        buttons.searchAndClickButtonBy(SEND_REQUISITE_TO_EMAIL_BUTTON);
        return this;
    }

    @Step("Тапнуть на кнопку \"ОК\"")
    public RequisitesPage tapOnOkButton() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
        return this;
    }

    @Step("Уведомление \"Введен некорректный Email адрес\" отображается")
    public boolean isDisplayMessageAboutIncorrectEmail() {
        return elements.getTextFromElement(COMMON_DIALOG_TEXT).contains(INCORRECT_EMAIL_MESSAGE_TEXT);
    }

    @Step("Уведомление \"Поле ввода не может быть пустым\" отображается")
    public boolean isDisplayMessageAboutFieldEmpty() {
        var textFromProperty = Text.FIELD_NOT_MAY_BE_EMPTY.getText();
        return elements.getTextFromElement(COMMON_DIALOG_TEXT).contains(textFromProperty);
    }

    @Step("Тап на значок вопроса в поле для ввода")
    public RequisitesPage tapOnHintInFieldForInput() {
        buttons.searchAndClickButtonBy(VIEW_PAYMENT_FIELD_HINT);
        return this;
    }
}
