package pages.android.demoversion.card;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.card.limits.DemoLimitsPage;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoCardPage extends DemoVersionMainPage {
    private static final String LIMITS_TEXT = "Лимиты";

    @AndroidFindBy(id = "cb.ibank:id/card_details_cashback_conditions")
    protected MobileElement CASHBACK_CONDITIONS;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_set_up_pin")
    protected MobileElement SET_PIN_CODE_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Действия']")
    protected MobileElement ACTIONS_BLOCK;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_limits")
    protected MobileElement LIMITS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_edit_pin_code")
    protected MobileElement EDIT_PIN_CODE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/card_details_cvc_cvv_button")
    protected MobileElement CARD_DETAILS_CVC_CVV_BUTTON;
    @AndroidFindBy(accessibility = "CVC2/CVV2")
    protected MobileElement CVC2_CVV2_BUTTON;
    @AndroidFindBy(accessibility = "Номер карты")
    protected MobileElement CARD_NUMBER_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_two_columns_icon")
    protected MobileElement COPY_CARD_NUMBER;
    @AndroidFindBy(id = "cb.ibank:id/view_two_columns_value")
    protected List<MobileElement> CARD_VALUE;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_tariff")
    protected MobileElement TARIFF_PLAN;


    @Step("Тапнуть на 'Условия программы'")
    public DemoCashBackConditionsPage scrollAndTapOnDetailsCashBackConditions() {
        var text = elements.getTextFromElement(CASHBACK_CONDITIONS);
        screen.scrollablePageAndroidByText(text);
        buttons.searchAndClickButtonBy(CASHBACK_CONDITIONS);

        return new DemoCashBackConditionsPage();
    }

    @Step("Проскроллить к блоку \"Действия\" и Тапнуть на \"Тарифный план\"")
    public DemoCashBackConditionsPage scrollAndTapOnTariffPlan() {
        var text = elements.getTextFromElement(TARIFF_PLAN);
        screen.scrollablePageAndroidByText(text);
        buttons.searchAndClickButtonBy(TARIFF_PLAN);

        return new DemoCashBackConditionsPage();
    }

    @Step("Проскроллить к блоку 'Действия'")
    public DemoCardPage scrollToActionsBlock() {
        screen.swipeScreenWithPressTime(Screen.Direction.UP, 1000, null);
        return this;
    }

    @Step("Тапнуть на опцию 'Установить ПИН-код'")
    public DemoCardPage tapOnSetPinCodeButton() {
        buttons.searchAndClickButtonBy(SET_PIN_CODE_BUTTON);
        return this;
    }

    @Step("Блок 'Действия' отображается в шторке с информацией по карте.")
    public boolean isDisplayActionsBlock() {
        return elements.isElementExist(ACTIONS_BLOCK);
    }

    @Step("Тапнуть на 'Лимиты'")
    public DemoLimitsPage tapOnLimitsButton() {
        screen.scrollablePageAndroidByText(LIMITS_TEXT);
        buttons.searchAndClickButtonBy(LIMITS_BUTTON);
        return new DemoLimitsPage();
    }

    @Step("Проскроллить к блоку 'Действия' и тапнуть на 'Изменить ПИН-код'")
    public DemoCardPage scrollAndTapOnEditPinCode() {
        screen.swipeScreenWithPressTime(Screen.Direction.UP, 1000, null);
        buttons.searchAndClickButtonBy(EDIT_PIN_CODE_BUTTON);
        return this;
    }

    @Step("Тапнуть на 'Показать номер карты и CVC/CVV'")
    public DemoCardPage tapOnCardDetailsCvcCvvButton() {
        buttons.searchAndClickButtonBy(CARD_DETAILS_CVC_CVV_BUTTON);

        return this;
    }

    @Step("Данные карты соответсвуют {args}'")
    public List<List<String>> checkCardValue(String... args) {
        List<String> expectedValue = Arrays.asList(args);
        CARD_VALUE.forEach(x -> waiters.isElementExist(x));

        List<String> currentValue = CARD_VALUE
                .stream().map(MobileElement::getText).collect(Collectors.toList());

        return Arrays.asList(expectedValue, currentValue);
    }

    @Step("Тапнуть на 'Номер карты'")
    public boolean tapOnCardNumberButton() {
        buttons.searchAndClickButtonBy(CARD_NUMBER_BUTTON);
        return elements.isSelectedElement(CVC2_CVV2_BUTTON);

    }

    @Step("Тапнуть на 'CVC2/CVV2'")
    public boolean tapOnCVC2CVV2() {
        buttons.searchAndClickButtonBy(CVC2_CVV2_BUTTON);
        return elements.isSelectedElement(CARD_NUMBER_BUTTON);
    }

    @Step("Тапнуть на кнопку копировать")
    public DemoCardPage tapOnCopyCardNumber() {
        buttons.searchAndClickButtonBy(COPY_CARD_NUMBER);
        return this;
    }

}
