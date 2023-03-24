package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

import static tests.TestDate.*;
import static utils.RandomUtils.*;

public class RegistrationTest extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    @Test
    void fillFormTest() {
      Faker faker = new Faker();
        String  UserFirstName = faker.name().firstName(),
                UserLastName = faker.name().lastName(),
                UserEmail = faker.internet().emailAddress(),
                UserGender = getRandomItemFromArray(genders),
                UserNumber = faker.phoneNumber().subscriberNumber(10),
                UserBirthDay_day = String.format("%02d", faker.number().numberBetween(1,28)),
                UserBirthDay_month = getRandomItemFromArray(months),
                UserBirthDay_year = String.valueOf(faker.number().numberBetween(1990,2000)),
                UserSubject = getRandomItemFromArray(subjects),
                UserHobby = getRandomItemFromArray(hobbies),
                UserPictureLocation = "pictures/cat.jpeg",
                UserAddress = faker.address().fullAddress(),
                UserState = "Haryana",
                UserCity = getRandomItemFromArray(cities);


        registrationPage.openPage()
                .removeBanners()
                .setFirstName(UserFirstName)
                .setLastName(UserLastName)
                .setEmail(UserEmail)
                .setGender(UserGender)
                .setNumber(UserNumber)
                .setBirthDate(UserBirthDay_day, UserBirthDay_month, UserBirthDay_year)
                .setSubject(UserSubject)
                .setHobby(UserHobby)
                .setPicture(UserPictureLocation)
                .setAddress(UserAddress)
                .setState(UserState)
                .setCity(UserCity)
                .submitButtonClick();

        registrationResultsModal.verifyModalAppear()
                .verifyResult("Student Name", UserFirstName + " " + UserLastName)
                .verifyResult("Student Email", UserEmail)
                .verifyResult("Gender", UserGender)
                .verifyResult("Mobile", UserNumber)
                .verifyResult("Date of Birth", UserBirthDay_day + " " + UserBirthDay_month + "," + UserBirthDay_year)
                .verifyResult("Subjects", UserSubject)
                .verifyResult("Hobbies", UserHobby)
                .verifyResult("Picture", "cat.jpeg")
                .verifyResult("Address", UserAddress)
                .verifyResult("State and City", UserState + " " + UserCity);
    }

}
