package core.base;

import org.testng.annotations.*;
import pages.android.PersonalCabinetMainPage;
import utils.mobile.Listener;

import static core.InitialDriver.*;

@Listeners(Listener.class)
public class BaseTest {
    protected AndroidBasePage androidBasePage = new AndroidBasePage();
    protected PersonalCabinetMainPage personalCabinetMainPage = new PersonalCabinetMainPage();


    @AfterClass
    public void afterMobileTests() {
        getAndroidDriver().resetApp();
        //TODO Через .startActivity для уменьшения логина
    }

//    @AfterSuite
//    public void afterSuiteTest() {
//        getAppiumDriver().removeApp(PropertiesConfig.getProperty("myAppPackage"));
//    }

}
