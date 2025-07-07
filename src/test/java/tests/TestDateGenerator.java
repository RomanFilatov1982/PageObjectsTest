package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static java.lang.String.format;
import static tests.TestDate.file;

public class TestDateGenerator {
    public static Faker faker = new Faker(new Locale("en-GB"));

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().firstName();
    }

    public static String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    public static String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getDate() {
        return format("%02d", faker.number().numberBetween(1, 9));
    }

    public static String getMonth() {
        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getYear() {
        return format("%s", faker.number().numberBetween(1900, 2025));
    }

    public static String getSubject() {
        return faker.options().option(TestDate.subject);
    }

    public static String getHobby() {
        return faker.options().option(TestDate.hobby);
    }

    public static String getFile() {
        return file;
    }

    public static String getState() {
        return faker.options().option(TestDate.mapStateWithCity.keySet().toArray()).toString();
    }

    public static String getCity(String state) {
        return faker.options().option(TestDate.mapStateWithCity.get(state));
    }
}
