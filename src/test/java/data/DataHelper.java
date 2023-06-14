package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

//    public static int generateRandomMonth() {
//        // Создаем объект класса Random для генерации случайных чисел
//        Random random = new Random();
//
//        // Генерируем случайное число от 1 до 12
//        int randomMonth = random.nextInt(12) + 1;
//        if (randomMonth < 10) {
//            return Integer.parseInt("0" + randomMonth);
//        } else {
//
//            return randomMonth;
//        }
//    }

    public static int getLastTwoDigitsOfYear() {
        // Получаем текущий год
        int currentYear = Year.now().getValue();

        // Извлекаем последние две цифры
        int lastTwoDigitsOfYear = currentYear % 100;

        // Возвращаем последние две цифры текущего года
        return lastTwoDigitsOfYear;
    }

    @Value
    public static class CardInfo {
        String cardNumber;

    }

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo("4444 4444 4444 4441");
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo("4444 4444 4444 4442");
    }

    public static CardInfo getUnknownCardInfo() {
        return new CardInfo("1111 1111 1111 1111");
    }
    public static CardInfo getZeroCardInfo() {
        return new CardInfo("0000 0000 0000 0000");
    }
    private static Faker faker = new Faker(new Locale("en"));

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    @Value
    public static class CvcCode {
        String code;
    }

    public static String generateCvcCode() {
        // Генерируем случайный набор цифр с использованием Faker
        String randomNumber = faker.number().digits(3);

        // Возвращаем сгенерированный набор цифр
        return randomNumber;
    }

    public static String generateRandomMonth() {
        // Генерируем случайное число от 1 до 12 с использованием Faker
        int randomMonth = faker.number().numberBetween(1, 13);
        String formattedMonth = String.format("%02d", randomMonth);

        // Возвращаем сгенерированный месяц в формате "01"-"12"
        return formattedMonth;
    }
    public static String text() {
        Faker faker = new Faker();

        String text = faker.lorem().characters(1000);
        return text;
    }
    public static String currentMonth() {

        LocalDate currentDate = LocalDate.now();
        String month = currentDate.format(DateTimeFormatter.ofPattern("MM"));

        return month;
    }

}




