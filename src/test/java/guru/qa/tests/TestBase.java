package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import guru.qa.utils.Data;
import guru.qa.utils.UserData;
import guru.qa.utils.UserDataGenerator;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Data data = new Data();
    UserDataGenerator userDataGenerator = new UserDataGenerator();
    UserData testData = userDataGenerator.generateUserData();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "770x1024";
    }
}
