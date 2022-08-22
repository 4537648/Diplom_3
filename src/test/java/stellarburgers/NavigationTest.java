package stellarburgers;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static stellarburgers.UserAction.*;

@DisplayName("Navigation cases")
public class NavigationTest extends Common {

    @Before
    public void setUp() {
        createUser(user);
        accessToken = getAccessTokenUser(user);
        userAuthentication(mainPage);
    }

    @Step("User authentication")
    public void userAuthentication(MainPage mainPage) {
        mainPage.accountButtonClick()
                .authFormFilling(user.getEmail(), user.getPassword())
                .loginButtonClick();
    }

    @Test
    @DisplayName("Account page opening via Account button click")
    public void loginPageOpening() {
        mainPage.accountButtonClick();
        page(AccountPage.class).getLogoutButton().shouldBe(visible);
    }

    @Test
    @DisplayName("Constructor page opening via Constructor button")
    public void constructorPageOpeningViaConstructorButton() {
        mainPage.accountButtonClick();
        mainPage.constructorButtonClick();
        mainPage.getConstructBurgerHeader().shouldBe(visible);
    }

    @Test
    @DisplayName("Constructor page opening via Stellar Burgers logo")
    public void constructorPageOpeningViaSBLogo() {
        mainPage.accountButtonClick();
        mainPage.stellarBurgersLogoClick();
        mainPage.getConstructBurgerHeader().shouldBe(visible);
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }
}