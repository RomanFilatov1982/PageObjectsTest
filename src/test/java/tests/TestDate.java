package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Map;

import static tests.TestDateGenerator.faker;

public class TestDate {


    public static final String[] subject = {"Maths", "Physics", "Chemistry", "Biology",
            "English", "History", "Geography", "Computer Science",
            "Economics", "Arts", "Hindi", "Social Studies"};
    public static final String file = "main-2.jpg";
    public static final String[] hobby = {"Sports", "Reading", "Music"};

    public static final Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
}
