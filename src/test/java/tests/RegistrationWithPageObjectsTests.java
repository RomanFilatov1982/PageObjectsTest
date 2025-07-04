package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestDate.*;


public class RegistrationWithPageObjectsTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    TestDate testDate = new TestDate();

    @Test
    void successfulFullFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(testDate.date, testDate.month, testDate.year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setUploadPicture(picture)
                .setCurrentAdress(streetAddress)
                .selectState(state)
                .selectCity(city)
                .submit()
                .checkForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", date + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulMinFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .setGender(gender)
                .submit()
                .checkForm();


        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Mobile", userNumber)
                .checkResult("Gender", gender);
    }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(" ")
                .setUserNumber(userNumber)
                .setDateOfBirth(testDate.date, testDate.month, testDate.year)
                .setEmail(userEmail)
                .submit();

        registrationPage.checkValidationErrors();
    }
}
