package tests;

import core.base.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import steps.autorization.LoginByPANSteps;

public class AuthWithStandStep extends BaseTest {

    @BeforeSuite
    @Parameters({"login", "password"})
    public void authorizeByLogin(String login, String password) {
        LoginByPANSteps.chooseTestStandAndLogin(login, password);
    }
}
