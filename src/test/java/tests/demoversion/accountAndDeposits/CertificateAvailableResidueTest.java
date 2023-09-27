package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.demoversion.DemoVersionMainTest;

public class CertificateAvailableResidueTest extends DemoVersionMainTest {

    @Test
    @TmsLink("31845")
    @Parameters("invalidEmail")
    public void certificateOfAvailableResidue(String invalidEmail) {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCertificateAvailableResidue()
                .fillTheEmailField(invalidEmail)
                .tapOnSendButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
