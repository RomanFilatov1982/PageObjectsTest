package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestDate.*;


public class RegistrationWithPageObjectsTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFullFormTest() {

        TestDateValues testDateValues = new TestDateValues();

        registrationPage.openPage()
                .closeReclame()
                .setFirstName(testDateValues.firstName)
                .setLastName(testDateValues.lastName)
                .setEmail(testDateValues.userEmail)
                .setGender(testDateValues.gender)
                .setUserNumber(testDateValues.userNumber)
                .setCalendar()
                .setDateOfBirth(testDateValues.date, testDateValues.month, testDateValues.year)
                .setSubjects(testDateValues.subject)
                .setHobbies(testDateValues.hobby)
                .setUploadPicture(testDateValues.picture)
                .setCurrentAdress(testDateValues.address)
                .selectState(testDateValues.state)
                .selectCity(testDateValues.city)
                .submit()
                .checkForm();


        registrationPage.checkResult("Student Name", testDateValues.firstName + " " + testDateValues.lastName)
                .checkResult("Student Email", testDateValues.userEmail)
                .checkResult("Gender", testDateValues.gender)
                .checkResult("Mobile", testDateValues.userNumber)
                .checkResult("Date of Birth", testDateValues.date + " " + testDateValues.month + "," + testDateValues.year)
                .checkResult("Subjects", testDateValues.subject)
                .checkResult("Hobbies", testDateValues.hobby)
                .checkResult("Picture", testDateValues.picture)
                .checkResult("Address", testDateValues.address)
                .checkResult("State and City", testDateValues.state + " " + testDateValues.city);
    }

    @Test
    void successfulMinFormTest() {

        TestDateValues testDateValues = new TestDateValues();

        registrationPage.openPage()
                .closeReclame()
                .setFirstName(testDateValues.firstName)
                .setLastName(testDateValues.lastName)
                .setUserNumber(testDateValues.userNumber)
                .setGender(testDateValues.gender)
                .submit()
                .checkForm();


        registrationPage.checkResult("Student Name", testDateValues.firstName + " " + testDateValues.lastName)
                .checkResult("Mobile", testDateValues.userNumber)
                .checkResult("Gender", testDateValues.gender);
    }

    @Test
    void negativeMinFormTest() {

        TestDateValues testDateValues = new TestDateValues();

        registrationPage.openPage()
                .closeReclame()
                .setFirstName(testDateValues.firstName)
                .setLastName(" ")
                .setUserNumber(testDateValues.userNumber)
                .setDateOfBirth(testDateValues.date, testDateValues.month, testDateValues.year)
                .setEmail(testDateValues.userEmail)
                .submit();

        registrationPage.checkValidationErrors();
    }
}
