package tests;

import com.github.javafaker.Faker;

import java.util.*;

public class TestDate {
    public static Faker faker = new Faker(new Locale("en-GB"));

    public static String firstName = faker.name().firstName(),
    lastName = faker.name().lastName(),
    userEmail = faker.internet().emailAddress(),
    streetAddress = faker.address().streetAddress(),
    userNumber = faker.phoneNumber().subscriberNumber(10);

    String[] genders = {"Male", "Female", "Other"};
    String gender = genders[new Random().nextInt(genders.length)];

    List<String> subjects = Arrays.asList(
            "Maths", "Physics", "Chemistry", "Biology",
            "English", "History", "Geography", "Computer Science",
            "Economics", "Arts", "Hindi", "Social Studies"
    );
    String subject = subjects.get(new Random().nextInt(subjects.size()));

    List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");

    String hobby = hobbies.get(new Random().nextInt(hobbies.size()));

    String picture = "main-2.jpg";

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

    final Date birthday = faker.date().birthday(1, 32);
    final int monthNumber = faker.number().numberBetween(1, 13);
    final int year = faker.number().numberBetween(1900, 2026);

}
