package pages.android.demoversion.more.smsAndEmailNotices;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoEmailAddition extends DemoVersionMainPage {

    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement EMAIL_EDITTEXT;


    @Step("Ввести в поле 'Email' email")
    public DemoEmailAddition inputEmailInEmailField(String email) {
        elements.searchFieldAndSendKey(EMAIL_EDITTEXT, email);
        return this;
    }
}
