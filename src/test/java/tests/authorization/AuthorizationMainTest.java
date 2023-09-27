package tests.authorization;

import core.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import pages.android.authorization.LoginPageForCard;
import pages.android.authorization.LoginPageForLogin;

import static core.InitialDriver.getAndroidDriver;

public class AuthorizationMainTest extends BaseTest {
    protected final LoginPageForLogin loginPageForLogin = LoginPageForLogin.getLoginPageForLogin();
    protected final LoginPageForCard loginPageForCard = LoginPageForCard.getLoginPageForCard();

    @BeforeMethod
    public void goToLoginPage() {
        loginPageForLogin
                .goToSignInPage();
    }
}
