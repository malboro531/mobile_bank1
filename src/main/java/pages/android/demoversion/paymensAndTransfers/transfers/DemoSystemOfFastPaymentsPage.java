package pages.android.demoversion.paymensAndTransfers.transfers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoSystemOfFastPaymentsPage extends DemoVersionMainPage {

    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_by_phone_and_sbp_account_view")
    protected MobileElement REFILL_ACCOUNT;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Зарплатный счет')]/ancestor::android.widget.LinearLayout[1]")
    protected MobileElement SALARY_ACCOUNT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_by_phone_and_sbp_account_phone_number")
    protected MobileElement PHONE_NUMBER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Перевод в УБРиР')]/..")
    protected MobileElement FIRST_PHONE_NUMBER;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Сумма')]")
    protected MobileElement TRANSFER_SUM;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Комментарий')]")
    protected MobileElement COMMENT_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_by_phone_and_sbp_button_next")
    protected MobileElement TRANSFER_BUTTON_SBP;


    @Step("Заполнить поля: ")
    public DemoSystemOfFastPaymentsPage fillInFieldsForSBP(String transferSum, String comment) {
        buttons.searchAndClickButtonBy(REFILL_ACCOUNT);
        buttons.searchAndClickButtonBy(SALARY_ACCOUNT);
        buttons.searchAndClickButtonBy(PHONE_NUMBER);
        buttons.searchAndClickButtonBy(FIRST_PHONE_NUMBER);
        elements.searchFieldAndSendKey(TRANSFER_SUM, transferSum);
        elements.searchFieldAndSendKey(COMMENT_TEXT, comment);

        return this;
    }

    @Step("Тапнуть кнопку 'Перевести'")
    public DemoSystemOfFastPaymentsPage tapOnTransferSBPButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON_SBP);
        return this;
    }
}
