package pages.android.depositsAndSavingAccount.deposits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class RateWithOptionPage extends OptionConditionsPage {
    @AndroidFindBy(id = "cb.ibank:id/view_controller_saving_account_month_rate_toolbar")
    protected MobileElement RATE_WITH_OPTION_TOOLBAR;
    @AndroidFindBy(id = "cb.ibank:id/view_option_detail_title")
    protected MobileElement ANNUAL_RATE_TITTLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_saving_account_month_rate_base_bonus")
    protected MobileElement MONTH_RATE_BASE_BONUS;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_saving_account_month_rate_levels_bonus_header")
    protected MobileElement RATE_LEVELS_BONUS_TITTLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_saving_account_month_rate_levels_payments_header")
    protected MobileElement RATE_LEVELS_PAYMENTS_TITTLE;



    @Step("Тапнуть кнопку \"Назад\"")
    public OptionConditionsPage tapOnBackButton() {
        buttons.searchAndClickButtonBy(BACK_BUTTON);
        return new OptionConditionsPage();
    }

    @Step("Экран \"Ставка из опцией\":")
    public boolean isDisplayRateWithOptionScreen() {
        return elements.isElementExist(RATE_WITH_OPTION_TOOLBAR) &&
                isDisplayAnnualRateField() &&
                isDisplayRateBonusField() &&
                isDisplayPaymentsPerMonth() &&
                isDisplayMonthRateBaseBonus();
    }

    @Step("Отображается поле \"Годовая ставка\" с описанием условий по ставкам")
    private boolean isDisplayAnnualRateField() {
        return elements.isElementExist(ANNUAL_RATE_TITTLE);
    }

    @Step("Отображается поле \"Бонусная ставка\"")
    private boolean isDisplayRateBonusField() {
        return elements.isElementExist(RATE_LEVELS_BONUS_TITTLE);
    }

    @Step("Отображается поле \"Покупки в месяц\"")
    private boolean isDisplayPaymentsPerMonth() {
        return elements.isElementExist(RATE_LEVELS_PAYMENTS_TITTLE);
    }

    @Step("Текст о возможности увеличить ставку с опцией отображается в голубом прямоугольнике со скругленными краями")
    private boolean isDisplayMonthRateBaseBonus() {
        return elements.isElementExist(MONTH_RATE_BASE_BONUS);
    }


}
