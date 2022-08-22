package stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

public class Common {

    String baseUrl = "https://stellarburgers.nomoreparties.site/";
    MainPage mainPage;

    User user = new User("John Appleseed", "user@example.com", "AM0941");
    String accessToken;

    @Before
    public void init() {
        RestAssured.baseURI = baseUrl;
        System.setProperty("selenide.browser", "chrome");
        mainPage = open(baseUrl, MainPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}



