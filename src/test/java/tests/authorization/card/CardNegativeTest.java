package tests.authorization.card;

import enums.Text;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.authorization.AuthorizationMainTest;

import static core.InitialDriver.getAndroidDriver;


public class CardNegativeTest extends AuthorizationMainTest {


    //Необхадимы тестовые данные!
    String cardNumber = "4301 8050 1560 1446";
    String password = "1111";


    @Test
    @TmsLink("29884")
    public void AccessTemporyBlocked() {
        testExecute(cardNumber, password, Text.ACCESS_TEMPORY_BLOCKED);
    }

    @Test
    @TmsLink("29885")
    public void UserBlocked() {
        testExecute(cardNumber, password, Text.USER_BLOCKED);
    }

    @Test
    @TmsLink("29886")
    public void AccessTerminated() {
        testExecute(cardNumber, password, Text.ACCESS_TERMINATED);
    }

    @Test
    @TmsLink("29887")
    public void insertWrongCardNumber() {
        testExecute("1234", "0000", Text.INVALID_FILLING_FIELDS);
    }

    @Test
    @TmsLink("29888")
    public void insertWrongPassword() {
        testExecute(cardNumber, password, Text.INVALID_PASSWORD);
    }

    @Test
    @TmsLink("29894")
    public void DontFoundUser() {
        testExecute(cardNumber, password, Text.DONT_FOUND_USER);
    }

    @AfterMethod
    public void afterMethod() {
        getAndroidDriver().closeApp();
    }

    private void testExecute(String cardNumber, String password, Text text) {
        String result = loginPageForLogin
                .tapOnByCardSection()
                .isDisplaySignInScreenAndSectionsForCard()
                .tapOnCardFieldAndInput(cardNumber.replaceAll("\\s", ""))
                .tapOnPasswordFieldAndInput(password)
                .tapOnSignInButton(text.getText());
        Assert.assertEquals(result, text.getText(),
                String.format("Ожидаемое сообщение: \"%s\"\n" +
                        "Фаткичесеки пришло: \"%s\"", text.getText(), result));
    }

}



