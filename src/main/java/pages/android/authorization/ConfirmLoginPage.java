package pages.android.authorization;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.PersonalCabinetMainPage;

import static core.InitialDriver.getAndroidDriver;

public class ConfirmLoginPage extends LoginPage {

    private static final String SMS_MESSAGE = "Мы отправили вам сообщение на";
    private static final String TIMER_TEXT = "Код действует:";
    private static final String TIME_OUT_TEXT = "Время действия кода истекло";
    private static final String CODE_INVALID_TEXT = "Код подтверждения введен неверно";
    private static final String ATTEMPTS_LIMIT_REACHED_TEXT = "Вы превысили допустимое количество попыток входа. Доступ будет заблокирован на 24 часа";
    private static final String ACCESS_TEMP_BLOCK_MESSAGE = "Доступ временно заблокирован. Обратитесь в банк или попробуйте войти позднее";

    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_title")
    protected MobileElement CONFIRM_SMS_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_edit_text")
    protected MobileElement CONFIRM_SMS_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_code_valid_timer")
    protected MobileElement SMS_CODE_VALID_TIMER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_button_confirm")
    protected MobileElement CONFIRM_SMS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_cancel")
    protected MobileElement CANCEL_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_ok")
    protected MobileElement OK_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    protected MobileElement COMMON_DIALOG_TEXT;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'ПОЗВОНИТЬ В БАНК')]/..")
    protected MobileElement CALL_TO_BANK_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_scroll_view")
    protected MobileElement CONFIRM_SMS_SCREEN;

    @Override
    boolean isDisplayTitle() {
        return elements.isElementExist(CONFIRM_SMS_SCREEN);
    }


    @Step("Ввести код из смс")
    public ConfirmLoginPage inputCheckingCodeInFieldByCode(String code) {
        elements.searchFieldAndSendKey(CONFIRM_SMS_FIELD, code);
        return this;
    }

    @Step("Тапнуть на кнопку \"Готово\"")
    public PersonalCabinetMainPage tapOnReadyButton() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buttons.searchAndClickButtonBy(CONFIRM_SMS_BUTTON);
        return new PersonalCabinetMainPage();
    }

    @Step("Тапнуть на кнопку \"Готово\"")
    public AccessRecoveryPage tapOnReadyButtonAfterAccessRecovery() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buttons.searchAndClickButtonBy(CONFIRM_SMS_BUTTON);
        return new AccessRecoveryPage();
    }

    @Step("Отображается экран подтверждения: ")
    public boolean isDisplayConfirmLoginScreenAndSections() {
        return isDisplayMessageAboutConfirmSms() &&
                isDisplayCheckingCodeField() &&
                isDisplayKeyboardOnScreen() &&
                isDisplayTimerAndContainsPhrase() &&
                isDisplayConfirmSmsButtonAndDisabled();
    }

    @Step("Отображается заголовок \"Мы отправили вам сообщение на ...\"")
    private boolean isDisplayMessageAboutConfirmSms() {
        var isExistMessage = elements.isElementExist(CONFIRM_SMS_TITLE);
        var isContainsMessagePhrase = elements.getTextFromElement(CONFIRM_SMS_TITLE).contains(SMS_MESSAGE);

        return isExistMessage && isContainsMessagePhrase;
    }

    @Step("Отображается поле \"Проверочный код #1\" в фокусе")
    private boolean isDisplayCheckingCodeField() {
        return elements.isElementExist(CONFIRM_SMS_FIELD);
    }

    @Step("Отображается клавиатура с цифрами")
    private boolean isDisplayKeyboardOnScreen() {
        return getAndroidDriver().isKeyboardShown();
    }

    @Step("Отображается таймер \"Код действует:\"")
    private boolean isDisplayTimerAndContainsPhrase() {
        var isExistField = elements.isElementExist(SMS_CODE_VALID_TIMER);
        var isContainsPhrase = elements.getTextFromElement(SMS_CODE_VALID_TIMER).contains(TIMER_TEXT);

        return isExistField && isContainsPhrase;
    }

    @Step("Отображается кнопка \"Готово\" (неактивна пока код не введен)")
    private boolean isDisplayConfirmSmsButtonAndDisabled() {
        var isExistButton = elements.isElementExist(CONFIRM_SMS_BUTTON);
        var isDisableButton = !elements.isEnableElement(CONFIRM_SMS_BUTTON);

        return isExistButton && isDisableButton;
    }

    @Step("Отображается алерт \"Код подтверждения введен неверно\"")
    public boolean isContainsMessageAboutInvalidCode() {
        return elements.getTextFromElement(COMMON_DIALOG_TEXT).contains(CODE_INVALID_TEXT);
    }

    @Step("Отображается алерт \"" + ATTEMPTS_LIMIT_REACHED_TEXT + "\"")
    public boolean isContainsMessageAboutAttemptsLimitReached() {
        return elements.getTextFromElement(COMMON_DIALOG_TEXT).contains(ATTEMPTS_LIMIT_REACHED_TEXT);
    }

    @Step("Отображаются кнопки \"ПОЗВОНИТЬ В БАНК\" и \"ОК\"")
    public boolean isDisplayCallToBankAndOkButton() {
        return elements.isElementExist(CALL_TO_BANK_BUTTON) && elements.isElementExist(OK_BUTTON);
    }

    @Step("Отображается алерт \"" + ACCESS_TEMP_BLOCK_MESSAGE + "\"")
    public boolean isDisplayAlertAboutAccessTempBlockMessage() {
        return elements.getTextFromElement(COMMON_DIALOG_TEXT).contains(ACCESS_TEMP_BLOCK_MESSAGE);
    }

    @Step("Тапнуть на кнопку \"ОК\"")
    public ConfirmLoginPage tapOnOkButton() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
        return this;
    }

    public String getNumberOfCheckingCode() {
        return elements.getTextFromElement(CONFIRM_SMS_FIELD).replaceAll("[^0-9]", "");
    }

    public boolean isExistAndContainsTextTimeOutMessage() {
        var isExistElement = elements.isElementExist(COMMON_DIALOG_TEXT);
        return isExistElement && elements.getTextFromElement(COMMON_DIALOG_TEXT).contains(TIME_OUT_TEXT);
    }
}
