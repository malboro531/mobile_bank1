package tests.demoversion.paymentsAndTransfers;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.demoversion.paymensAndTransfers.DemoPaymentsAndTransfersPage;

public class PaymentsAndTransfersMainTest extends BaseTest {
    protected final DemoPaymentsAndTransfersPage demoPaymentsAndTransfersPage = new DemoPaymentsAndTransfersPage();

    @BeforeClass
    public void goToDemoVersionAndPayments() {
        androidBasePage
                .goToDemoVersion()
                .tapOnPaymentsButton();
    }
}
