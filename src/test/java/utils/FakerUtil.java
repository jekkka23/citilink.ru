package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerUtil {

    private static final Faker faker = new Faker(new Locale("en-US"));

    public static String generatePhoneNumber() {
        return faker.number().digits(11); //корректный номер телефона
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        return faker.internet().password(6, 10); // Пароль длиной от 6 до 10 символов
    }

    public static String generateInvalidPhoneNumber() {
        return faker.number().digits(9); // Номер телефона с 9 цифрами (некорректный)
    }

    public static String generateInvalidEmail() {
        return faker.internet().emailAddress().replace("@", ""); // Некорректный email без '@'
    }

    public static String generateInvalidPassword() {
        return faker.internet().password(1, 5); // Пароль длиной менее 6 символов
    }
}