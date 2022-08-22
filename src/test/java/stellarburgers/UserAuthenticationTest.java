package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static stellarburgers.UserAction.*;

@DisplayName("User authentication cases")
public class UserAuthenticationTest extends Common {

    @Before
    public void setUp() {
        createUser(user);
        accessToken = getAccessTokenUser(user);
    }

    @Test
    @DisplayName("User authentication via login button at Main page")
    public void userAuthenticationViaLoginButtonAtMainPage() {
        mainPage.loginMainButtonClick()
                .authFormFilling(user.getEmail(), user.getPassword())
                .loginButtonClick();
        mainPage.getCompleteOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("User authentication via Account button")
    public void userAuthenticationViaAccountButton() {
        mainPage.accountButtonClick()
                .authFormFilling(user.getEmail(), user.getPassword())
                .loginButtonClick();
        mainPage.getCompleteOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("User authentication via login link at Registration page")
    public void userAuthenticationViaLoginButtonAtRegistrationPage() {
        mainPage.accountButtonClick()
                .registrationLinkClick()
                .loginLinkClick()
                .authFormFilling(user.getEmail(), user.getPassword())
                .loginButtonClick();
        mainPage.getCompleteOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("User authentication via login button at Password recovery page")
    public void userAuthenticationViaLoginButtonAtPasswordRecoveryPage() {
        mainPage.accountButtonClick()
                .passwordRecoveryLinkClick()
                .loginLinkClick()
                .authFormFilling(user.getEmail(), user.getPassword())
                .loginButtonClick();
        mainPage.getCompleteOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("User account sign-out")
    public void accountSignout() {
        mainPage.accountButtonClick()
                .authFormFilling(user.getEmail(), user.getPassword())
                .loginButtonClick();
        mainPage.getCompleteOrderButton().shouldBe(visible);
        mainPage.accountButtonClick();
        page(AccountPage.class).logoutButtonClick();
        webdriver().shouldHave(url(baseUrl + "login"));
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }
}