package pages.android.depositsAndSavingAccount.deposits;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.PersonalCabinetMainPage;

public class DepositPage extends PersonalCabinetMainPage {

    @AndroidFindBy(xpath = "//*[@resource-id = 'cb.ibank:id/toolbar_title' and @text='Вклад']")
    protected MobileElement DEPOSIT_PAGE_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/item_account_details_header_icon_hint")
    protected MobileElement HINT_DETAILS_MORE_PLUSES;
    @AndroidFindBy(xpath = "//*[@text = 'Подробная информация']/..")
    protected MobileElement DETAILS_INFO;


    @Step("Экран \"Вклад\" с подключенной опцией отображается")
    public boolean isDisplayDepositScreen() {
        return elements.isElementExist(DEPOSIT_PAGE_TITLE);
    }

    @Step("Тапнуть хинт \"?\" в блоке \"Опция \"Больше плюсов\"\"")
    public OptionConditionsPage tapOnHintInOptionMorePluses() {
        waiters.waitForVisibility(DETAILS_INFO);
        screen.swipeScreenWithPressTime(Screen.Direction.UP, 1000, null);
        buttons.searchAndClickButtonBy(HINT_DETAILS_MORE_PLUSES);

        return new OptionConditionsPage();
    }
}
