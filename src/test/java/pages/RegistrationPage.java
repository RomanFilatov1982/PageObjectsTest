package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormResult;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAdress = $("#currentAddress"),
            userState = $("#state"),
            userCity = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            modalDialog = $(".modal-dialog");

    CalendarComponent calendarComponent = new CalendarComponent();
    FormResult formResult = new FormResult();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage closeReclame() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter().scrollTo();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String resourcePath) {
        uploadPictureInput.uploadFromClasspath(resourcePath);
        return this;
    }

    public RegistrationPage setCurrentAdress(String value) {
        currentAdress.setValue(value);
        return this;
    }

    public RegistrationPage selectState(String value) {
        userState.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        userCity.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public void checkForm() {
        modalDialog.should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public RegistrationPage checkResult(String key, String value) {
        formResult.result(key, value);
        return this;
    }

    public RegistrationPage checkValidationErrors() {
        $("html").shouldHave(cssClass("was-validated"));
        firstNameInput.shouldBe(visible);
        lastNameInput.shouldBe(visible);
        userEmailInput.shouldBe(visible);
        userNumberInput.shouldBe(visible);
        return this;
    }

}