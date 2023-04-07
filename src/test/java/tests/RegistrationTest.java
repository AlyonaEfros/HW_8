package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

import static tests.TestDate.*;
import static utils.RandomUtils.*;

@Tag("demoqa")
public class RegistrationTest extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @DisplayName("Проверка регистрационной формы студента")

    @Test
    void fillFormTest() {
      Faker faker = new Faker();
        String  userFirstName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(genders),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                userBirthDay_day = String.format("%02d", faker.number().numberBetween(1,28)),
                userBirthDay_month = getRandomItemFromArray(months),
                userBirthDay_year = String.valueOf(faker.number().numberBetween(1990,2000)),
                userSubject = getRandomItemFromArray(subjects),
                userHobby = getRandomItemFromArray(hobbies),
                userPictureLocation = "cat.jpeg",
                userAddress = faker.address().fullAddress(),
                userState = "Haryana",
                userCity = getRandomItemFromArray(cities);


        registrationPage.openPage()
                .bannerRemoval()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(userBirthDay_day, userBirthDay_month, userBirthDay_year)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .setPicture("pictures/" + userPictureLocation)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submitButtonClick();


        registrationResultsModal.verifyModalAppear()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", userBirthDay_day + " " + userBirthDay_month + "," + userBirthDay_year)
                .verifyResult("Subjects", userSubject)
                .verifyResult("Hobbies", userHobby)
                .verifyResult("Picture", userPictureLocation)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }

}
