package steps.autorization;

import core.base.BaseStep;
import io.qameta.allure.Step;
import pages.android.PersonalCabinetMainPage;
import pages.android.authorization.ConfirmLoginPage;
import pages.android.authorization.LoginPageForLogin;
import utils.EnvVariablesGetter;
import utils.integration.fimi.SOAPClientSAAJ;

import static core.InitialDriver.getAndroidDriver;

public class LoginByPANSteps extends BaseStep {
    protected static LoginPageForLogin loginPageForLogin = LoginPageForLogin.getLoginPageForLogin();
    protected static PersonalCabinetMainPage personalCabinetMainPage = new PersonalCabinetMainPage();


    @Step("Выбрать стенд и залогиниться")
    public static void chooseTestStandAndLogin(String login, String password) {
        var port = EnvVariablesGetter.getValueFromEnvironmentVariableByKey("TEST_PORT");
        chooseTestStand(port);
        login(login, password);
    }

    @Step("Выбор тестового стенда. Выбран: \"{port}\"")
    public static void chooseTestStand(String port) {
        androidBasePage.tapOnTestSettingsButtonAndChooseStand(port);
    }

    @Step("Валидный вход по логину")
    public static void login(String login, String password) {
        loginPageForLogin
                .goToSignInPage()
                .tapOnIDOrLoginFieldAndInput(login)
                .tapOnPasswordFieldAndInput(password)
                .tapOnSignInButton()
                .inputCheckingCodeInFieldByCode(getCheckingCode(login))
                .tapOnReadyButton()
                .tapOnFingerPrintCancelButtonIfExistIt()
                .tapRepeatedlyOnOnboardingNextButton();
    }

    private static String getCheckingCode(String login) {
        return SOAPClientSAAJ.getDynamicCodeByHisNumber(
                new ConfirmLoginPage()
                        .getNumberOfCheckingCode(),
                login
        );
    }
}
