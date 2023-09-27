package tests.demoversion.card;

import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.demoversion.card.DemoCardPage;
import tests.demoversion.DemoVersionMainTest;

import java.util.List;

public class ViewCardTest extends DemoVersionMainTest {

    // TODO: 03.02.2022 Разобратся с чтением сообщения из Toast 
    @TmsLinks({@TmsLink(value = "32784"), @TmsLink(value = "31847")})
    @Test
    public void viewCardNumber() {
        SoftAssert softAsserts = new SoftAssert();

        DemoCardPage democardpage = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithNumber("3438")
                .tapOnCardDetailsCvcCvvButton();
        //Проверяем соответствие номера/даты
        List<List<String>> checkcardvalue = democardpage
                .checkCardValue("0123  4500  0000  3438", "09/19");

        boolean tapOnCVC2CVV2 = democardpage
                .tapOnCopyCardNumber()
                .tapOnCVC2CVV2();

        List<List<String>> checkCardValue1 = democardpage
                .checkCardValue("000");

        boolean tapOnCardNumberButton = democardpage
                .tapOnCardNumberButton();

        softAsserts.assertEquals(checkcardvalue.get(0), checkcardvalue.get(1), "Номер/дата карты не соответствует ожиданию");
        softAsserts.assertFalse(tapOnCVC2CVV2, "Вкладка Номер карты активна");
        softAsserts.assertEquals(checkCardValue1.get(0), checkCardValue1.get(1), "CVC2/CVV2  карты не соответствует ожиданию");
        softAsserts.assertFalse(tapOnCardNumberButton, "Вкладка CVC2/CVV2  активна");
        softAsserts.assertAll();
    }

}
