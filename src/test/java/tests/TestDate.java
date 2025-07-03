package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

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

    hobby = faker.options().option("Sports", "Reading", "Music"),
    picture = faker.file("main-2.jpg") ;

    String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    String state = faker.options().option(states);

    Map<String, List<String>> stateCityMap = new HashMap<>();
stateCityMap.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
stateCityMap.put("Uttar Pradesh", Arrays.asList("Agra", "Lucknow", "Merrut"));
stateCityMap.put("Haryana", Arrays.asList("Karnal", "Panipat"));
stateCityMap.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));

    String state = faker.options().option(stateCityMap.keySet().toArray(new String[0]));
    List<String> cities = stateCityMap.get(state);
    String city = faker.options().option(cities.toArray(new String[0]));

    LocalDate randomDate = faker.date().birthdayLocalDate();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

}
