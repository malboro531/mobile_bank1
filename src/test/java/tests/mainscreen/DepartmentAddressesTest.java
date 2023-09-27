package tests.mainscreen;

import core.base.BaseTest;
import io.qameta.allure.Flaky;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.mainscreen.DepartmentAddressesPage;

public class DepartmentAddressesTest extends BaseTest {
    private final DepartmentAddressesPage addressesPage = new DepartmentAddressesPage();

    @Test
    @Flaky
    @TmsLink("9444")
    public void departmentAndATMAddresses() {
        var actualResult = addressesPage
                .goToDepartmentAddressesPage()
                .goToAddressDepartmentToSingleVariant()
                .tapOnArrowButton()
                .isDisplayedAdditionalInfo();

        Assert.assertTrue(actualResult);
    }
}
