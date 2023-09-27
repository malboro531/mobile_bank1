package steps.autorization;

import core.base.BaseStep;
import pages.android.authorization.AccessRecoveryPage;
import pages.android.authorization.LoginPageForCard;

public class AccessRecoverySteps extends BaseStep {
    protected static LoginPageForCard loginPageForCard = LoginPageForCard.getLoginPageForCard();

    public static AccessRecoveryPage goToAccessRecoveryByCard() {
        return loginPageForCard
                .tapOnByCardSection()
                .tapOnForgotPassword()
                .tapOnCardNumberFieldAndInputCard("4301805015601446")
                .tapOnSignInButton()
                .tapOnReadyButtonAfterAccessRecovery();
    }
}
