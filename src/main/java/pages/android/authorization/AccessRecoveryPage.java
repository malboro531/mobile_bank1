package pages.android.authorization;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class AccessRecoveryPage extends LoginPage {

    @AndroidFindBy(id = "cb.ibank:id/view_controller_get_access_by_card_number_edit_text")
    private MobileElement CARD_NUMBER_INPUT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_get_access_by_card_button_continue")
    private MobileElement SIGN_IN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_get_access_by_card_title")
    private MobileElement ACCESS_RECOVERY_TITTLE;
    @AndroidFindBy(id = "cb.ibank:id/text_input_end_icon")
    private MobileElement CARD_SCAN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_create_password_create_title")
    private MobileElement CREATE_PASSWORD_TITTLE;
    @AndroidFindBy(id = "cb.ibank:id/view_pincode_button_0")
    private MobileElement BUTTON_ZERO;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_create_password_confirm_title")
    private MobileElement CONFIRM_PASSWORD_TITLE;

    @Override
    boolean isDisplayTitle() {
        return elements.isElementExist(ACCESS_RECOVERY_TITTLE);
    }

    private static AccessRecoveryPage instanse;

    public static AccessRecoveryPage getAccessRecoveryPage() {
        if (instanse == null) {
            return new AccessRecoveryPage();
        }
        return instanse;
    }

    @Step("Отображается экран \"Создание пароля\" (придумайте пароль)")
    public boolean isDisplayCreatingPasswordScreen() {
        return elements.isElementExist(CREATE_PASSWORD_TITTLE);
    }

    @Step("Отображается экран \"Восстановление доступа\":")
    public boolean isDisplayAccessRecoveryScreen() {
        return isDisplayTitle() &&
                isDisplayCarNumberField() &&
                isDisplayScanCardButton() &&
                isDisplaySignInButtonAfterCardInput();

    }

    @Step("Тапнуть на поле \"Номер карты\"\n" +
            "Ввести номер карты ( 4301 8183 7499 6323 )")
    public AccessRecoveryPage tapOnCardNumberFieldAndInputCard(String cardNumber) {
        elements.searchFieldAndSendKey(CARD_NUMBER_INPUT, cardNumber);
        return this;
    }

    @Step("Тапнуть на кнопку \"Войти\"")
    public ConfirmLoginPage tapOnSignInButton() {
        buttons.searchAndClickButtonBy(SIGN_IN_BUTTON);
        return new ConfirmLoginPage();
    }

    @Step("Отображается текст \"Придумайте пароль\"")
    public boolean isDisplayCreatePasswordTittle() {
        return elements.isElementExist(CREATE_PASSWORD_TITTLE);
    }

    @Step("Ввести 4-значный пароль")
    public AccessRecoveryPage inputPassword() {
        for (int i = 0; i < 4; i++) {
            buttons.searchAndClickButtonBy(BUTTON_ZERO);
        }
        return this;
    }

    @Step("Тапнуть на кнопку Х (закрыть)")
    public AccessRecoveryPage tapOnCloseButtonAfterAccessRecovery() {
        buttons.searchAndClickButtonBy(BACK_BUTTON);
        return this;
    }

    @Step("Тапнуть на кнопку \"Отмена\"")
    public AccessRecoveryPage tapOnCancelButton() {
        buttons.searchAndClickButtonBy(CANCEL_BUTTON);
        return this;
    }

    @Step("Тапнуть на кнопку \"Прервать\"")
    public AccessRecoveryPage tapOnAbortButton() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
        return this;
    }

    @Step("Отображается алерт \"Вы уверенны что хотите прервать процесс получения доступа?\"")
    public String isDisplayAlertAboutStoppingAccessRecovery() {
        return elements.getTextFromElement(COMMON_DIALOG_TEXT).trim();
    }

    @Step("Отображается текст \"Повторите пароль\"")
    public boolean isDisplayConfirmPasswordTittle() {
        return elements.isElementExist(CONFIRM_PASSWORD_TITLE);
    }

    @Step("Отображается поле \"Номер карты\"")
    private boolean isDisplayCarNumberField() {
        return elements.isElementExist(CARD_NUMBER_INPUT);
    }

    @Step("Отображается кнопка \"Отсканировать карту\" (иконка в поле для ввода ноиера карты)")
    private boolean isDisplayScanCardButton() {
        return elements.isElementExist(CARD_SCAN_BUTTON);
    }

    @Step("Отображается кнопка \"Войти\"")
    private boolean isDisplaySignInButtonAfterCardInput() {
        return elements.isElementExist(SIGN_IN_BUTTON);
    }
}
