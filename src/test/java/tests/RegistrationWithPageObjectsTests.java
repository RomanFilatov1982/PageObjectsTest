package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFullFormTest() {

        registrationPage.openPage()
                .closeReclame()
                .setFirstName("Roman")
                .setLastName("Filatov")
                .setEmail("romanf@gmail.com")
                .setGender("Male")
                .setUserNumber("9085693730")
                .setDateOfBirth("18", "January", "1982")
                .setSubjects("Physics")
                .setHobbies("Sports")
                .setUploadPicture("img/main-2.jpg")
                .setCurrentAdress("Proxladnaya street 28")
                .selectState("Haryana")
                .selectCity("Karnal")
                .submit()
                .checkForm();

        registrationPage.checkResult("Student Name", "Roman" + " " + "Filatov")
                .checkResult("Student Email", "romanf@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9085693730")
                .checkResult("Date of Birth", "18" + " " + "January" + "," + "1982")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "main-2.jpg")
                .checkResult("Address", "Proxladnaya street 28")
                .checkResult("State and City", "Haryana" + " " + "Karnal");

    }

    @Test
    void successfulMinFormTest() {
        registrationPage.openPage()
                .closeReclame()
                .setFirstName("Roman")
                .setLastName("Filatov")
                .setUserNumber("9085693730")
                .setGender("Male")
                .submit()
                .checkForm();


        registrationPage.checkResult("Student Name", "Roman" + " " + "Filatov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9085693730");

    }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .closeReclame()
                .setFirstName("Roman")
                .setLastName(" ")
                .setUserNumber("9085693730")
                .setDateOfBirth("18", "January", "1982")
                .setEmail("romanfgmail.com")
                .submit();

        registrationPage.checkValidationErrors();
    }
}
