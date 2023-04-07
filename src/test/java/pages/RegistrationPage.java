package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            dateOfBirthInput = $(".react-datepicker-wrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    @Step("Открываем регистрационную форму студента")
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;

    }

    @Step("Убираем баннеры и footer")
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Вводим имя студента")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим фамилию студента")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим Email студента")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Вводим номер телефона студента")
    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    @Step("Выбираем гендер студента")
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    @Step("Вводим дату рождения студента")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбираем предметы студента")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби студента")
    public RegistrationPage setHobby(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем фотографию")
    public RegistrationPage setPicture(String img) {
        uploadPicture.uploadFromClasspath(img);

        return this;
    }

    @Step("Вводим адрес студента")
    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Нажимаем на кнопку подтверждения")
    public void submitButtonClick() {
        submit.click();
    }

}

