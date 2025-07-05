package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    SelenideElement selectCalendar = $("#dateOfBirthInput");
    SelenideElement selectMonth = $(".react-datepicker__month-select");
    SelenideElement selectYear = $("select.react-datepicker__year-select");
    SelenideElement selectDay = $(".react-datepicker__day--0" + day);
        :

    not(.react -datepicker__day--outside-month);

    public void setDate(String day, String month, String year) {


        selectCalendar.click();
        selectMonth.selectOption(month);
        selectYear.selectOption(year);
        selectDay.click();
    }
}
