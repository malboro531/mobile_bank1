package pages.android.demoversion.accountsAndDeposits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoRequisitesPage extends DemoVersionMainPage {
    private static final String REQUISITES_FIELDS = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]";
    private static final String BENEFICIARY_TEXT = "Beneficiary";

    @AndroidFindBy(id = "cb.ibank:id/share")
    protected MobileElement SHARE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/item_detail_body")
    protected MobileElement ITEM_DETAIL;
    @AndroidFindBy(xpath = REQUISITES_FIELDS)
    protected MobileElement FIELD_REQUISITE;

}
