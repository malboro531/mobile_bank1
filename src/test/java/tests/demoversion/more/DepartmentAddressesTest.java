package tests.demoversion.more;

import io.qameta.allure.Flaky;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.demoversion.more.DemoDepartmentAddressesPage;

public class DepartmentAddressesTest extends MoreMainTest {

    @Test
    @Flaky
    @TmsLink("24528")
    public void isDisplayCityMap() {
        SoftAssert softAssert = new SoftAssert();
        var isDisplayMapCity = demoMorePage
                .tapOnDepartmentAddresses()
                .isDisplayMapCity();
        var departmentAddressesPage = new DemoDepartmentAddressesPage();
        var actualResult = departmentAddressesPage
                .tapOnListOfAddresses()
                .isDisplayListOfAddresses();

        softAssert.assertTrue(isDisplayMapCity);
        softAssert.assertTrue(actualResult);
        softAssert.assertAll();
    }
}
