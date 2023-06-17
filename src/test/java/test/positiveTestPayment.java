package test;


import com.codeborne.selenide.Configuration;

import data.DataHelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import page.DashBoard;

import static com.codeborne.selenide.Selenide.*;


public class positiveTestPayment {

    @BeforeEach
    void setUp() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        Configuration.timeout = 15000;
    }

    @Test
    public void positiveTestWithApprovedCardPaymentService() {
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
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");


    }

    @Test
    public void positiveTestWithUnknownCardPaymentService() {

        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
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

    @Test  //оформить ишью
    public void positiveTestWithDeclinedCardPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
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
}
