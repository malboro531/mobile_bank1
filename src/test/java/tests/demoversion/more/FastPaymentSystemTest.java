package tests.demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.demoversion.more.DemoFastPaymentSystemPage;

public class FastPaymentSystemTest extends MoreMainTest {

    @Test
    @TmsLink("31898")
    public void isDisplayedInfoFromAlertSBP() {
        SoftAssert softAssert = new SoftAssert();
        var isDisplayedInfoText = demoMorePage
                .tapOnFastPaymentSystem()
                .tapOnHintAboutFastPaymentSystem()
                .tapOnCloseButton()
                .tapOnPhoneField()
                .tapOnOtherNumber()
                .tapOnSPBSettingsAccountHint()
                .isDisplayedInfoText();
        var actualResult = new DemoFastPaymentSystemPage()
                .tapOnOkButtonAndGoToSBP()
                .tapOnAgreeConditionsCheckbox()
                .tapOnConnectButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();
        softAssert.assertTrue(isDisplayedInfoText);
        softAssert.assertTrue(actualResult);
        softAssert.assertAll();
    }
}
