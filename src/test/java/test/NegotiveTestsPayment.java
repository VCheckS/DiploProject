package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import data.StringGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashBoard;

import static com.codeborne.selenide.Selenide.open;

public class NegotiveTestsPayment {

    @BeforeEach
    void setUp() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        Configuration.timeout = 15000;
    }

    @Test
    public void EmptyCardFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();

        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));

        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findMustBeFilledMessage("Поле обязательно для заполнения");
    }

    @Test
    public void EmptyMonthFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));

        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyYearFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);

        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);

        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCardFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = StringGenerator.stringCard();
        dashboard.getCardInfo().setValue(cardNumber);
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        dashboard.getMonth().setValue("Q, q");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void InvalidMonthFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        dashboard.getMonth().setValue("!, @");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        dashboard.getMonth().setValue("й, `");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        dashboard.getYear().setValue("й, `");
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        dashboard.getYear().setValue("!, @");
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        dashboard.getYear().setValue("Q, q");
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = StringGenerator.stringCard();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        dashboard.getCvc().setValue("Q, !, @");
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }



    @Test
    public void ScriptProtectionCardFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getCardInfo().setValue("<script> alert('Hello!');</script>");
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void textNameFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.text();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Превышена максимальная длина Имени");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        dashboard.getMonth().setValue("0','0");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        dashboard.getMonth().setValue("1','3");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }


    @Test
    public void limitCheckYearFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.currentMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear();
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
    }


    @Test
    public void limitCheckYearFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.currentMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 6;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }
}
