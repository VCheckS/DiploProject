package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import data.StringGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NegotiveTestsPayment {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }

    @Test
    public void EmptyCardFieldPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        // String month = String.valueOf(10);
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void EmptyNameFieldPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        // String month = String.valueOf(10);
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void EmptyMonthFieldPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void EmptyYearFieldPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void EmptyCvcFieldPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void InvalidCardFieldPaymentService() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = StringGenerator.stringCard();
        $$(".input__control").get(0).setValue(cardNumber);
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void InvalidMonthFieldPaymentService1() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        $$(".input__control").get(1).setValue("Q, q");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void InvalidMonthFieldPaymentService2() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        $$(".input__control").get(1).setValue("!, @");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void InvalidMonthFieldPaymentService3() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        $$(".input__control").get(1).setValue("й, `");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void InvalidYearFieldPaymentService1() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));

        $$(".input__control").get(2).setValue("й, `");
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void InvalidYearFieldPaymentService2() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));

        $$(".input__control").get(2).setValue("!, @");
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void InvalidYearFieldPaymentService3() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));

        $$(".input__control").get(2).setValue("Q, q");
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    public void InvalidNameFieldPaymentService1() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = StringGenerator.stringCard();
        $$(".input__control").get(3).setValue(name);
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    public void InvalidCvcFieldPaymentService1() {

        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue("Q, !, @");

        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }


    @Test
    public void ScriptProtectionCardFieldPaymentServ() {
        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue("<script> alert('Hello!');</script>");
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    @Test
    public void textNameFieldPaymentServ() {
        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear()+1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.text();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Превышена максимальная длина Имени")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    @Test
    public void limitCheckMonthFieldPaymentServ1() {
        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();

        $$(".input__control").get(1).setValue("0','0");
        var year = DataHelper.getLastTwoDigitsOfYear()+1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    @Test
    public void limitCheckMonthFieldPaymentServ2() {
        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();

        $$(".input__control").get(1).setValue("1','3");
        var year = DataHelper.getLastTwoDigitsOfYear()+1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("ННеверно указан срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    @Test
    public void limitCheckYearFieldPaymentServ1() {
        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear()+1;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Успешно")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    @Test
    public void limitCheckYearFieldPaymentServ2() {
        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.generateRandomMonth();
        $$(".input__control").get(1).setValue(String.valueOf(month));
        var year = DataHelper.getLastTwoDigitsOfYear()+6;
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Успешно")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    @Test
    public void limitCheckYearFieldPaymentServ3() {
        SelenideElement button = $x("//*[contains(text(), 'Купить')]");
        button.click();
        var month = DataHelper.currentMonth();
        $$(".input__control").get(1).setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear();
        $$(".input__control").get(2).setValue(String.valueOf(year));
        var cardNumber = DataHelper.getApprovedCardInfo();
        $$(".input__control").get(0).setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        $$(".input__control").get(3).setValue(String.valueOf(name));
        var cvc = DataHelper.generateCvcCode();
        $$(".input__control").get(4).setValue(String.valueOf(cvc));
        $$("button").find(exactText("Продолжить")).click();
        $(byText("Успешно")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}