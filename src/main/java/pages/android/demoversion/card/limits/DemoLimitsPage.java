package pages.android.demoversion.card.limits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.android.demoversion.DemoVersionMainPage;

import static core.InitialDriver.getAndroidDriver;

public class DemoLimitsPage extends DemoVersionMainPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Все расходы в месяц')]/..")
    protected MobileElement ALL_EXPENSES_PER_MONTH_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_limits_fab")
    protected MobileElement ADD_LIMIT;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Операции в Интернет в сутки']")
    protected MobileElement INTERNET_TRANSACTIONS_PER_DAY;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Расходы за границей в сутки']")
    protected MobileElement SPENDING_ABROAD_PER_DAY;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Все расходы в сутки']")
    protected MobileElement ALL_EXPENSES_PER_DAY;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Выдача наличных в сутки']")
    protected MobileElement CASH_WITH_PER_DAY;


    @Step("Тапнуть на 'Все расходы в месяц'")
    public DemoLimitManagementPage tapOnAllExpensesPerMonthButton() {
        buttons.searchAndClickButtonBy(ALL_EXPENSES_PER_MONTH_BUTTON);
        return new DemoLimitManagementPage();
    }

    @Step("Тапнуть на 'Добавить'")
    public DemoLimitsPage tapOnAddLimitButton() {
        buttons.searchAndClickButtonBy(ADD_LIMIT);
        return this;
    }

    @Step("Тапнуть на 'Операции в Интернет в сутки'")
    public DemoLimitManagementPage tapOnInternetTransactionsPerDay() {
        buttons.searchAndClickButtonBy(INTERNET_TRANSACTIONS_PER_DAY);
        return new DemoLimitManagementPage();
    }

    @Step("Тапнуть на 'Расходы за границей в сутки'")
    public DemoLimitManagementPage TapOnIspendingAbroadPerDay() {
        buttons.searchAndClickButtonBy(SPENDING_ABROAD_PER_DAY);
        return new DemoLimitManagementPage();
    }

    @Step("Тапнуть на 'Все расходы в сутки'")
    public DemoLimitManagementPage tapOnAllExpensesPerDay() {
        buttons.searchAndClickButtonBy(ALL_EXPENSES_PER_DAY);
        return new DemoLimitManagementPage();
    }

    @Step("Тапнуть на 'Выдача наличных в сутки'")
    public DemoLimitManagementPage tapOnCashWithPerDay() {
        buttons.searchAndClickButtonBy(CASH_WITH_PER_DAY);
        return new DemoLimitManagementPage();
    }

    @Step("Тапнуть на '{allure}'")
    public DemoLimitManagementPage tapOnCash(LIMITS_TYPE key, String allure) {
        buttons.searchAndClickButtonBy(
                 getAndroidDriver()
                        .findElement(By.xpath(key.getXpath())));
        return new DemoLimitManagementPage();
    }

    public enum LIMITS_TYPE {
        INTERNET_TRANSACTIONS_PER_DAY("Операции в Интернет в сутки"),
        SPENDING_ABROAD_PER_DAY("Расходы за границей в сутки"),
        ALL_EXPENSES_PER_DAY("Все расходы в сутки"),
        CASH_WITH_PER_DAY("Выдача наличных в сутки");

        public final String name;

        LIMITS_TYPE(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String getXpath() {
            return String.format("//android.widget.TextView[@text='%s']", this.getName());
        }
    }

}