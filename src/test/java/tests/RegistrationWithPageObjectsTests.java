package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFillFormTest() {

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
                .modalForm();

        registrationPage.checkResult("Student Name", "Roman Filatov")
                .checkResult("Student Email", "romanf@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9085693730")
                .checkResult("Date of Birth", "18 January,1982")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "")
                .checkResult("Adress", "Proxladnaya street 28")
                .checkResult("State and Sity", "Haryana Karnal");
    }
    @Test
    void successfulMinFormTest() {
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName("Filatov")
                .setUserNumber("9085693730")
                .setGender("Male")
                .submit()
                .modalForm();


        registrationPage.checkResult("Student Name", "Roman Filatov")
                .checkResult("Mobile", "9085693730")
                .checkResult("Gender", "Male");
    }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName(" ")
                .setUserNumber("9085693730")
                .setDateOfBirth("18", "January", "1982")
                .setEmail("romanfgmail.com")
                .submit()
                .modalForm();

        registrationPage.checkResultNeg("Student Name", "Roman ")
                .checkResult("Student Email", "romanfgmail.com")
                .checkResult("Mobile", "9085693730")
                .checkResult("Date of Birth", "18 January,1982");
    }
}
