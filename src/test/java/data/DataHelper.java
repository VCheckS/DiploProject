package data;

import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
    private DataHelper() {
    }

    public static int generateRandomMonth() {
        // Создаем объект класса Random для генерации случайных чисел
        Random random = new Random();

        // Генерируем случайное число от 1 до 12
        int randomMonth = random.nextInt(12) + 1;

        // Возвращаем сгенерированное число
        return randomMonth;
    }
}