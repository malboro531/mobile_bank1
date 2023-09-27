package pages.android.authorization;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class LoginPageForLogin extends LoginPage {


    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_login_title")
    protected MobileElement LOGIN_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_login_edit_text_layout")
    protected MobileElement LOGIN_TEXTFIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_password_edit_text_layout")
    protected MobileElement PASSWORD_TEXTFIELD;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Идентификатор / логин')]")
    protected MobileElement LOGIN_PLACEHOLDER;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Пароль')]")
    protected MobileElement PASSWORD_PLACEHOLDER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_forgot_login_or_password")
    protected MobileElement FORGOT_LOGIN_OR_PASSWORD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_login")
    protected MobileElement SIGN_IN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_progress")
    protected MobileElement PROGRESS_SPINNER_ON_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    protected MobileElement PROGRESS_BUTTON;

    private static LoginPageForLogin instance;

    private LoginPageForLogin() {
        super();
    }

    public static LoginPageForLogin getLoginPageForLogin() {
        if (instance == null) {
            return new LoginPageForLogin();
        }
        return instance;
    }

    // TODO: 04.02.2022 Переписать проверку наличия элементов на экране
    @Step("Отображается экран входа в МБ, разделы")
    public LoginPageForLogin isDisplaySignInScreenAndSectionsForLogin() {
        isDisplaySignInScreenAndSections();
        softAssert.assertTrue(BY_LOGIN_SECTION.isSelected(), "Вход по логину не выбран");
        softAssert.assertTrue(isDisplayTitle(), "Не отображается заголовок \"Вход в мобильный банк по логину\"");
        softAssert.assertTrue(isDisplayIDOrLoginField(), "Не отображается поле \"Идентификатор / логин\"");
        softAssert.assertTrue(isDisplayPasswordField(), "Не отображается поле \"Пароль\"");
        softAssert.assertTrue(isDisplayForgotLoginOrPasswordButton(), "Не отображаются кнопка \"Забыли логин или пароль?\"");
        softAssert.assertTrue(isDisplaySignInButton(), "Не отображаются кнопка \"Войти\"");
        softAssert.assertAll();
        return this;
    }


    @Step("Тапнуть на поле \"Идентификатор / логин\"" +
            "Ввести логин ({idOrLogin})")
    public LoginPageForLogin tapOnIDOrLoginFieldAndInput(String idOrLogin) {
        buttons.searchAndClickButtonBy(LOGIN_TEXTFIELD);
        elements.sendKeyFromAction(idOrLogin);
        return this;
    }

    @Step("Тапнуть на поле \"Пароль\"" +
            "Ввести пароль ({password})")
    public LoginPageForLogin tapOnPasswordFieldAndInput(String password) {
        buttons.searchAndClickButtonBy(PASSWORD_TEXTFIELD);
        elements.sendKeyFromAction(password);
        return this;
    }

    @Step("Тап на кнопку 'Войти'")
    public ConfirmLoginPage tapOnSignInButton() {
        buttons.searchAndClickButtonBy(SIGN_IN_BUTTON);
        return new ConfirmLoginPage();
    }


    @Step("Кнопка 'Ок' отображается на экране")
    public boolean isExistOKButtonOnScreen() {
        return elements.isElementExist(PROGRESS_BUTTON);
    }


    @Step("Отображается заголовок \"Вход в мобильный банк по логину\"")
    protected boolean isDisplayTitle() {
        return elements.isElementExist(LOGIN_TITLE)
                && LOGIN_TITLE.getText().equals("Вход в мобильный банк \nпо логину");
    }

    @Step("Отображается поле \"Идентификатор / логин\"")
    private boolean isDisplayIDOrLoginField() {
        return elements.isElementExist(LOGIN_PLACEHOLDER)
                && LOGIN_PLACEHOLDER.getText().equals("Идентификатор / логин");
    }

    @Step("Отображается поле \"Пароль\"")
    private boolean isDisplayPasswordField() {
        return elements.isElementExist(PASSWORD_PLACEHOLDER)
                && PASSWORD_PLACEHOLDER.getText().equals("Пароль");
    }

    @Step("Отображаются кнопка \"Забыли логин или пароль?\"")
    private boolean isDisplayForgotLoginOrPasswordButton() {
        return elements.isElementExist(FORGOT_LOGIN_OR_PASSWORD_BUTTON) &&
                FORGOT_LOGIN_OR_PASSWORD_BUTTON.getText().equals("Забыли логин\nили пароль?");

    }

    @Step("Отображаются кнопка и \"Войти\"")
    private boolean isDisplaySignInButton() {
        return elements.isElementExist(SIGN_IN_BUTTON);
    }

    @Step("В полях формы присутствует плейсхолдер")
    private boolean isExistPlaceholdersInForm() {
        return elements.isElementExist(LOGIN_PLACEHOLDER) && elements.isElementExist(PASSWORD_PLACEHOLDER);
    }


}
