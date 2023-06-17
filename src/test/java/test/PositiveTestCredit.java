package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashBoard;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PositiveTestCredit {
    @BeforeEach
    void setUp() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        Configuration.timeout = 15000;
    }

    @Test
    public void positiveTestWithApprovedCardCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
    }
//        SelenideElement button = $x("//*[contains(text(), 'Купить в кредит')]");
//        button.click();
//        var month = DataHelper.generateRandomMonth();
//        $$(".input__control").get(1).setValue(String.valueOf(month));
//        var year = DataHelper.getLastTwoDigitsOfYear()+1;
//        $$(".input__control").get(2).setValue(String.valueOf(year));
//        var cardNumber = DataHelper.getApprovedCardInfo();
//        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
//        var name = DataHelper.generateRandomName();
//        $$(".input__control").get(3).setValue(String.valueOf(name));
//        var cvc = DataHelper.generateCvcCode();
//        $$(".input__control").get(4).setValue(String.valueOf(cvc));
//        $$("button").find(exactText("Продолжить")).click();
//        $(byText("Успешно")).shouldBe(Condition.visible, Duration.ofSeconds(15));


    @Test
    public void positiveTestWithUnknownCardCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();;
        var cardNumber = DataHelper.getUnknownCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findErrorMessage("Ошибка");
    }
//        SelenideElement button = $x("//*[contains(text(), 'Купить в кредит')]");
//        button.click();
//        var month = DataHelper.generateRandomMonth();
//        $$(".input__control").get(1).setValue(String.valueOf(month));
//        var year = DataHelper.getLastTwoDigitsOfYear()+1;
//        $$(".input__control").get(2).setValue(String.valueOf(year));
//        var cardNumber = DataHelper.getUnknownCardInfo();
//        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
//        var name = DataHelper.generateRandomName();
//        $$(".input__control").get(3).setValue(String.valueOf(name));
//        var cvc = DataHelper.generateCvcCode();
//        $$(".input__control").get(4).setValue(String.valueOf(cvc));
//        $$("button").find(exactText("Продолжить")).click();
//        $(byText("Ошибка")).shouldBe(Condition.visible, Duration.ofSeconds(15));


    @Test  //оформить ишью
    public void positiveTestWithDeclinedCardCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        var cardNumber = DataHelper.getDeclinedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findErrorMessage("Ошибка");

    }
//        SelenideElement button = $x("//*[contains(text(), 'Купить в кредит')]");
//        button.click();
//        var month = DataHelper.generateRandomMonth();
//        $$(".input__control").get(1).setValue(String.valueOf(month));
//        var year = DataHelper.getLastTwoDigitsOfYear()+1;
//        $$(".input__control").get(2).setValue(String.valueOf(year));
//        var cardNumber = DataHelper.getDeclinedCardInfo();
//        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
//        var name = DataHelper.generateRandomName();
//        $$(".input__control").get(3).setValue(String.valueOf(name));
//        var cvc = DataHelper.generateCvcCode();
//        $$(".input__control").get(4).setValue(String.valueOf(cvc));
//        $$("button").find(exactText("Продолжить")).click();
//        $(byText("Ошибка")).shouldBe(Condition.visible, Duration.ofSeconds(15));
//
//    }
}

