package data;

import java.security.SecureRandom;

public class StringGenerator {
        public static String stringCard() {
            // Вызываем метод для генерации случайной строки
            String randomString = generateRandomString(16);
        return randomString;
        }

        public static String generateRandomString(int length) {
            // Создаем массив символов, содержащий различные специальные символы и буквы
            char[] characters = {'!', '@', '#', '$', '%', '&', 'A', 'B', 'C', 'D', 'E', 'F'};

            // Создаем объект класса SecureRandom для генерации случайных чисел
            SecureRandom random = new SecureRandom();

            // Создаем StringBuilder для построения случайной строки
            StringBuilder stringBuilder = new StringBuilder();

            // Генерируем случайные символы и добавляем их в StringBuilder до достижения нужной длины
            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(characters.length);
                char randomChar = characters[randomIndex];
                stringBuilder.append(randomChar);
            }

            // Возвращаем сгенерированную строку
            return stringBuilder.toString();
        }
    }

