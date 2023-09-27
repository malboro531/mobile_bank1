package pages.android.demoversion;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.accountsAndDeposits.DemoAccountPage;
import pages.android.demoversion.more.DemoMorePage;
import pages.android.demoversion.paymensAndTransfers.DemoPaymentsAndTransfersPage;

public class DemoVersionMainPage extends AndroidBasePage {
    private static final String NOT_AVAILABLE_MESSAGE = "Недоступно в демо-режиме";
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[contains(@text, 'Зарплатный счет')]/..")
    protected MobileElement SALARY_ACCOUNT;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    protected MobileElement NOT_AVAILABLE_IN_DEMO_VERSION_ALERT;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_more")
    protected MobileElement MORE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/done")
    protected MobileElement DONE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_main_action_button")
    protected MobileElement PAYMENTS_BUTTON;



    @Step("Тапнуть на счет 'Зарплатный Счет'")
    public DemoAccountPage goToAccountPage() {
        buttons.searchAndClickButtonBy(SALARY_ACCOUNT);
        return new DemoAccountPage();
    }

    @Step("Всплывает предупреждение 'Недоступно в демо-режиме'")
    public boolean isExistAlertAboutNotAvailableInDemoVersionAndTapOK() {
        var isExistAlert = elements.getTextFromElement(NOT_AVAILABLE_IN_DEMO_VERSION_ALERT).equals(NOT_AVAILABLE_MESSAGE);
        tapOnOkButtonInNotification();

        return isExistAlert;
    }

    @Step("Тапнуть на кнопку 'Ок' в уведомлении")
    public void tapOnOkButtonInNotification() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
    }

    @Step("Тапнуть 'Еще'")
    public DemoMorePage goToMorePage() {
        buttons.searchAndClickButtonBy(MORE_BUTTON);
        return new DemoMorePage();
    }

    @Step("Тапнуть на 'Готово'")
    public DemoVersionMainPage tapOnDone() {
        buttons.searchAndClickButtonBy(DONE_BUTTON);
        return this;
    }

    @Step("Тапнуть на 'Платежи'")
    public DemoPaymentsAndTransfersPage tapOnPaymentsButton() {
        buttons.searchAndClickButtonBy(PAYMENTS_BUTTON);
        return new DemoPaymentsAndTransfersPage();
    }
}
