package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class FirstTest extends TestBase {

    String birthday = format(
            "%s %s,%s",
            testData.birthDate.day,
            testData.birthDate.month,
            testData.birthDate.year
    );
    String firstSubject = "Arts";
    String secondSubject = "Social Studies";
    String firstHobby = "Sports";
    String secondHobby = "Reading";
    String filename = "image-for-autotest.jpg";
    String state = "Haryana";
    String city = "Panipat";

    @Test
    void fillAutomationPracticeForm() {
        // fill all fields
        registrationFormPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .selectGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setBirthdayDate(testData.birthDate)
                .selectSubject(firstSubject)
                .selectSubject(secondSubject)
                .selectHobby(firstHobby)
                .selectHobby(secondHobby)
                .uploadPicture(filename)
                .setAddress(testData.address)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        // check results
        registrationFormPage
                .checkResultsTableIsVisible()
                .checkResults(data.nameField, testData.firstName + " " + testData.lastName)
                .checkResults(data.emailField, testData.email)
                .checkResults(data.genderField, testData.gender)
                .checkResults(data.phoneField, testData.phoneNumber)
                .checkResults(data.birthdayField, birthday)
                .checkResults(data.subjectField, firstSubject + ", " + secondSubject)
                .checkResults(data.hobbyField, firstHobby + ", " + secondHobby)
                .checkResults(data.imageField, filename)
                .checkResults(data.addressField, testData.address)
                .checkResults(data.stateAndCityField, state + " " + city);
    }
}
