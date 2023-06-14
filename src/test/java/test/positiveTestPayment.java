package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.Month;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class positiveTestPayment {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }

    @Test
    public void positiveTestWithApprovedCardPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear()-1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Истёк срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
    @Test
    public void positiveTestWithUnknownCardPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear()+1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getUnknownCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Ошибка")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
    @Test  //оформить ишью
    public void positiveTestWithDeclinedCardPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear()+1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getDeclinedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Ошибка")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
}
