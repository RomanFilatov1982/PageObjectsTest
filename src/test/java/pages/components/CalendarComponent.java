package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $("select.react-datepicker__year-select").selectOption("1982");
        $(".react-datepicker__day--018").click(); //:not(.react-datepicker__day--outside-month)
    }
}
