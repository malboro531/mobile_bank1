package pages.android.authorization;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public abstract class LoginPage extends AndroidBasePage {

    SoftAssert softAssert = new SoftAssert();

    @AndroidFindBy(xpath = "//androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.view.ViewGroup")
    protected MobileElement FORM_CONTAINER;
    @AndroidFindBy(accessibility = "По Логину")
    protected MobileElement BY_LOGIN_SECTION;
    @AndroidFindBy(accessibility = "По карте")
    protected MobileElement BY_CARD_SECTION;


    @Step("Отображается экран входа в МБ")
    protected boolean isDisplayScreenWithFormForLogin() {
        return elements.isElementExist(FORM_CONTAINER);
    }

    @Step("Отображается раздел \"По логину\"")
    protected boolean isExistByLoginSection() {
        return elements.isElementExist(BY_LOGIN_SECTION);
    }

    @Step("Отображается раздел \"По карте\"")
    protected boolean isExistByCardSection() {
        return elements.isElementExist(BY_CARD_SECTION);
    }

    @Step("Тапнуть на \"По логину\"")
    public LoginPageForLogin tapOnByLoginSection() {
        buttons.searchAndClickButtonBy(BY_CARD_SECTION);
        return LoginPageForLogin.getLoginPageForLogin();
    }

    @Step("Тапнуть на \"По карте\"")
    public LoginPageForCard tapOnByCardSection() {
        buttons.searchAndClickButtonBy(BY_CARD_SECTION);
        return LoginPageForCard.getLoginPageForCard();
    }

    @Step("Проверяем сообщения об ошибке ({text})")
    public String isExistFailAlertAfterSignIn(String text) {
        return elements.getTextFromElement(COMMON_DIALOG_TEXT);
    }

    abstract boolean isDisplayTitle();


    protected void isDisplaySignInScreenAndSections() {
        softAssert.assertTrue(isDisplayScreenWithFormForLogin(), "Не отображается экран входа в Мобильный Банк");
        softAssert.assertTrue(isExistByLoginSection(), "Не отображается раздел \"По логину\"");
        softAssert.assertTrue(isExistByCardSection(), "Не отображается раздел \"По карте\"");
        softAssert.assertAll();
    }



}
