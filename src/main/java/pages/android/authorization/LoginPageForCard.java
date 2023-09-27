package pages.android.authorization;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class LoginPageForCard extends LoginPage {


    @AndroidFindBy(id = "cb.ibank:id/view_controller_sign_in_with_card_title")
    protected MobileElement CARD_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sign_in_with_card_field_card")
    protected MobileElement CARD_TEXTFIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sign_in_with_card_field_password")
    protected MobileElement PASSWORD_TEXTFIELD;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'логин')]")
    protected MobileElement LOGIN_PLACEHOLDER;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Пароль')]")
    protected MobileElement PASSWORD_PLACEHOLDER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sign_in_with_card_forgot_password")
    protected MobileElement FORGOT_PASSWORD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_sign_in_with_card_enter_button")
    protected MobileElement SIGN_IN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_progress")
    protected MobileElement PROGRESS_SPINNER_ON_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    protected MobileElement PROGRESS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/text_input_end_icon")
    protected MobileElement SCAN_CARD;

    @Step("Тапнуть на кнопку \"Войти\"")
    public ConfirmLoginPage tapOnSignInButton() {
        buttons.searchAndClickButtonBy(SIGN_IN_BUTTON);
        return new ConfirmLoginPage();
    }

    @Step("Тапнуть на кнопку \"Войти\" и проверить текст ошибки ({text})")
    public String tapOnSignInButton(String text) {
        buttons.searchAndClickButtonBy(SIGN_IN_BUTTON);
        return isExistFailAlertAfterSignIn(text);
    }

    @Step("Тапнуть на поле \"Номер карты\"" +
            "Ввести номер карты ({cardNumber})")
    public LoginPageForCard tapOnCardFieldAndInput(String cardNumber) {
        buttons.searchAndClickButtonBy(CARD_TEXTFIELD);
        elements.sendKeyFromAction(cardNumber);
        return this;
    }

    @Step("Тапнуть на поле \"Пароль\"" +
            "Ввести пароль ({password})")
    public LoginPageForCard tapOnPasswordFieldAndInput(String password) {
        buttons.searchAndClickButtonBy(PASSWORD_TEXTFIELD);
        elements.sendKeyFromAction(password);
        return this;
    }

    @Step("Тапнуть на кнопку \"Забыли пароль?\"")
    public AccessRecoveryPage tapOnForgotPassword() {
        buttons.searchAndClickButtonBy(FORGOT_PASSWORD_BUTTON);
        return new AccessRecoveryPage();
    }

    @Step("Отображается заголовок \"Вход в мобильный банк по номеру карты\"")
    protected boolean isDisplayTitle() {
        return elements.isElementExist(CARD_TITLE)
                && CARD_TITLE.getText().equals("Вход в мобильный банк \nпо номеру карты");
    }


    @Step("Отображается поле \"Номер карты\"")
    private boolean isDisplayIDOrCardField() {
        return elements.isElementExist(CARD_TEXTFIELD)
                && CARD_TEXTFIELD.getText().equals("Номер карты");
    }

    @Step("Отображается поле \"Пароль\"")
    private boolean isDisplayPasswordField() {
        return elements.isElementExist(PASSWORD_TEXTFIELD)
                && PASSWORD_TEXTFIELD.getText().equals("Пароль");
    }

    @Step("Отображается поле \"Сканировать карту\"")
    private boolean isDisplayScanCard() {
        return elements.isElementExist(SCAN_CARD);
    }

    @Step("Отображается кнопка \"Забыли пароль?\"")
    private boolean isDisplayForgotPasswordButton() {
        return elements.isElementExist(FORGOT_PASSWORD_BUTTON)
                && FORGOT_PASSWORD_BUTTON.getText().equals("Забыли\nпароль?");

    }

    @Step("Отображается кнопка \"Войти\"")
    private boolean isDisplaySignInButton() {
        return elements.isElementExist(SIGN_IN_BUTTON);
    }


    // TODO: 04.02.2022 Переписать проверку наличия элементов на экране

    @Step("Отображается экран входа в МБ, разделы")
    public LoginPageForCard isDisplaySignInScreenAndSectionsForCard() {
        isDisplaySignInScreenAndSections();
        softAssert.assertTrue(BY_CARD_SECTION.isSelected(), "Вход по карте не выбран");
        softAssert.assertTrue(isDisplayTitle(), "Не отображается заголовок \"Вход в мобильный банк по номеру карты\"");
        softAssert.assertTrue(isDisplayIDOrCardField(), "Не отображается поле \"Номер карты\"");
        softAssert.assertTrue(isDisplayPasswordField(), "Не отображается поле \"Пароль\"");
        softAssert.assertTrue(isDisplayScanCard(), "Не отображается поле \"Сканировать карту\"");
        softAssert.assertTrue(isDisplayForgotPasswordButton(), "Не отображаются кнопка \"Забыли пароль?\"");
        softAssert.assertTrue(isDisplaySignInButton(), "Не отображаются кнопка \"Войти\"");
        softAssert.assertAll();
        return this;
    }


    private static LoginPageForCard instanse;

    public static LoginPageForCard getLoginPageForCard() {
        if (instanse == null) {
            return new LoginPageForCard();
        }
        return instanse;
    }


}
