package tests.demoversion;

import core.base.BaseTest;

import org.testng.annotations.BeforeClass;
import pages.android.demoversion.accountsAndDeposits.DemoAccountPage;


public class DemoVersionMainTest extends BaseTest {
    protected final DemoAccountPage demoAccountPage = new DemoAccountPage();

    @BeforeClass
    public void goToDemoVersion() {
        androidBasePage
                .goToDemoVersion();
    }
}
