package pages.android.mainscreen;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BecomeClientPage extends AndroidBasePage {
    @AndroidFindBy(id = "cb.ibank:id/view_controller_choose_product_switcher")
    protected MobileElement BECOME_CLIENT_CONTAINER;


    public boolean isExistBecomeClientContainer() {
        return elements.isElementExist(BECOME_CLIENT_CONTAINER);
    }
}
