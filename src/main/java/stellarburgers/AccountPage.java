package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {

    // локатор кнопки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()= 'Выход']")
    private SelenideElement logoutButton;

    // метод возвращает локатор кнопки "Выход"
    public SelenideElement getLogoutButton() {
        return logoutButton;
    }

    @Step("Logout button click action")
    public void logoutButtonClick() {
        logoutButton.click();
    }
}