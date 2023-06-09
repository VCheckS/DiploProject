import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

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
    public void shouldTestV1() {

        SelenideElement button = $x("//*[contains(text(), 'Купить в кредит')]");
        button.click();
       // String month = String.valueOf(10);
        var month = DataHelper.generateRandomMonth();


        $$(".input__control").get(1).setValue(String.valueOf(month));


//div[contains(@class, 'Test')]




    }
}