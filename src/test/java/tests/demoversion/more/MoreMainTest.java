package tests.demoversion.more;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.demoversion.more.DemoMorePage;

import static core.InitialDriver.getAndroidDriver;

public class MoreMainTest extends BaseTest {
    protected final DemoMorePage demoMorePage = new DemoMorePage();

    @BeforeClass
    public void goToDemoVersionAndMore() {
        androidBasePage
                .goToDemoVersion()
                .goToMorePage();
    }
}
