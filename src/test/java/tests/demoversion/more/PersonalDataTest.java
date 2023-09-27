package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.demoversion.more.DemoPersonalDataPage;

public class PersonalDataTest extends MoreMainTest {

    @Test
    @TmsLink("31900")
    public void showPersonalDataTest() {
        SoftAssert softAssert = new SoftAssert();
        var isExistAlertAboutNotAvailableInDemoVersionAndTapOK = demoMorePage
                .tapOnPersonalData()
                .tapOnCodeWordButton()
                .tapOnShowCodeWord()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();
        var actualResult = new DemoPersonalDataPage()
                .tapOnEditCodeWord()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        softAssert.assertTrue(isExistAlertAboutNotAvailableInDemoVersionAndTapOK);
        softAssert.assertTrue(actualResult);
        softAssert.assertAll();
    }
}
