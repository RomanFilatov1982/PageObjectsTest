package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDate {
    public static Faker faker = new Faker(new Locale("en-GB"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            streetAddress = faker.address().streetAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            gender = faker.options().option("Male", "Female", "Other"),
            subject = faker.options().option("Maths", "Physics", "Chemistry", "Biology",
                    "English", "History", "Geography", "Computer Science",
                    "Economics", "Arts", "Hindi", "Social Studies"),
            date = String.format("%s", faker.number().numberBetween(1, 28)),
            month = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            year = String.format("%s", faker.number().numberBetween(1900, 2025)),

    hobby = faker.options().option("Sports", "Reading", "Music"),

    picture = faker.options().option("main-2.jpg"),

    state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = selectCity(state);

    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}
