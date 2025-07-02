package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFullFormTest() {

        registrationPage.openPage()
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

        registrationPage.checkResult();

    }
    @Test
    void successfulMinFormTest() {
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName("Filatov")
                .setUserNumber("9085693730")
                .setGender("Male")
                .submit()
                .checkForm();


        registrationPage.checkResult();

    }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName(" ")
                .setUserNumber("9085693730")
                .setDateOfBirth("18", "January", "1982")
                .setEmail("romanfgmail.com")
                .submit();

        registrationPage.checkValidationErrors();
    }
}
