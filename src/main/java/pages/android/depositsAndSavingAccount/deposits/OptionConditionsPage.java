package pages.android.depositsAndSavingAccount.deposits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class OptionConditionsPage extends DepositPage {
    @AndroidFindBy(xpath = "//*[@text = 'Условия опции']")
    protected MobileElement OPTION_CONDITIONS;
    @AndroidFindBy(xpath = "//*[@text = 'Базовая ставка']")
    protected MobileElement BASE_RATE_TITTLE;
    @AndroidFindBy(id = "cb.ibank:id/conditions_of_option_base_rate")
    protected MobileElement BASE_RATE_VALUE;
    @AndroidFindBy(id = "cb.ibank:id/conditions_of_option_bonus_rate_title")
    protected MobileElement BONUS_RATE_TITTLE;
    @AndroidFindBy(id = "cb.ibank:id/conditions_of_option_bonus_rate")
    protected MobileElement BONUS_RATE_VALUE;
    @AndroidFindBy(id = "cb.ibank:id/conditions_of_option_how_rate_is_formed")
    protected MobileElement HOW_RATE_IS_FORMED;
    @AndroidFindBy(id = "cb.ibank:id/conditions_of_option_cost_description")
    protected MobileElement COST_DESCRIPTION;


    @Step("Тапнуть ссылку \"Как формируется ставка\"")
    public RateWithOptionPage tapOnHowRateFormedLink() {
        buttons.searchAndClickButtonBy(HOW_RATE_IS_FORMED);
        return new RateWithOptionPage();
    }

    @Step("Экран \"Условия опции\":")
    public boolean isDisplayOptionsConditionsShower() {
        return isDisplayOptionConditionsShower() &&
                isDisplayBaseRate() &&
                isDisplayRateWithBonuses() &&
                isDisplayButtonHowRateIsFormed() &&
                isDisplayCostDescription();
    }

    @Step("Шторка \"Условия опции\" отображается")
    public boolean isDisplayOptionConditionsShower() {
        return elements.isElementExist(OPTION_CONDITIONS);
    }

    @Step("Отображается поле \"Базовая ставка\"")
    private boolean isDisplayBaseRate() {
        return elements.isElementExist(BASE_RATE_TITTLE) && elements.isElementExist(BASE_RATE_VALUE);
    }

    @Step("Отображается поле \"Ставка с учетом бонусов\"")
    private boolean isDisplayRateWithBonuses() {
        return elements.isElementExist(BONUS_RATE_TITTLE) && elements.isElementExist(BONUS_RATE_VALUE);
    }

    @Step("Ссылка \"Как формируется ставка\" отображается")
    private boolean isDisplayButtonHowRateIsFormed() {
        return elements.isElementExist(HOW_RATE_IS_FORMED);
    }

    @Step("Текст серого цвета с описанием стоимости и порядка отключения опции отображается в нижней части шторки")
    private boolean isDisplayCostDescription() {
        return elements.isElementExist(COST_DESCRIPTION);
    }
}
