//package pages.android.tests.demoversion.accountsAndDeposits;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//import pages.android.tests.demoversion.DemoVersionMainPage;
//
//public class AccountStatementPage extends DemoVersionMainPage {
//    @AndroidFindBy(id = "cb.ibank:id/include_statements_and_references_email_text")
//    protected MobileElement EMAIL_FIELD;
//    @AndroidFindBy(id = "cb.ibank:id/include_statements_and_references_account")
//    protected MobileElement SALARY_ACCOUNT;
//    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.view.ViewGroup")
//    protected MobileElement FIRST_VARIANT_OF_ACCOUNT;
//    @AndroidFindBy(id = "cb.ibank:id/view_controller_statement_period_container")
//    protected MobileElement PERIOD_CONTAINER;
//    @AndroidFindBy(id = "cb.ibank:id/view_controller_statement_send_button")
//    protected MobileElement SEND_BUTTON;
//
//    public AccountStatementPage(AppiumDriver<MobileElement> appiumDriver) {
//        super(appiumDriver);
//    }
//}
