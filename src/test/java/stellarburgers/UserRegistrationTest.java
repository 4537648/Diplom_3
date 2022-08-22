package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static stellarburgers.UserAction.deleteUser;
import static stellarburgers.UserAction.getAccessTokenUser;

@DisplayName("User registration cases")
public class UserRegistrationTest extends Common {

    @Test
    @DisplayName("User registration with proper password")
    public void userRegistration() {
        mainPage.accountButtonClick()
                .registrationLinkClick()
                .registrationFormFilling(user.getName(), user.getEmail(), user.getPassword())
                .submitRegistrationButtonClick();
        deleteUser(getAccessTokenUser(user));
        webdriver().shouldHave(url(baseUrl + "login"), Duration.ofSeconds(3));
    }

    @Test
    @DisplayName("User registration with improper password")
    public void userRegistrationWithIncorrectPassword() {
        mainPage.accountButtonClick()
                .registrationLinkClick()
                .registrationFormFilling(user.getName(), user.getEmail(), "AM941")
                .submitRegistrationButtonClick();
        page(RegistrationPage.class).getIncorrectPassword().shouldHave(text("Некорректный пароль"));
    }
}