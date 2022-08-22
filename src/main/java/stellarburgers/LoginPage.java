package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    // локатор поля ввода "Email"
    @FindBy(how = How.XPATH, using = ".//label[text()= 'Email']/following-sibling::input")
    private SelenideElement emailField;

    // локатор поля ввода "Пароля"
    @FindBy(how = How.XPATH, using = ".//input[@name= 'Пароль']")
    private SelenideElement passwordField;

    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()= 'Войти']")
    private SelenideElement loginButton;

    // локатор гиперссылки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[text()= 'Зарегистрироваться']")
    private SelenideElement registrationLink;

    // локатор гиперссылки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[text()= 'Восстановить пароль']")
    private SelenideElement passwordRecoveryLink;

    // метод возвращает элемент кнопки "Войти"
    public SelenideElement getLoginButton() {
        return loginButton;
    }

    @Step("Authorization form filling action")
    public LoginPage authFormFilling(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        return this;
    }

    @Step("Registration link click action")
    public RegistrationPage registrationLinkClick() {
        registrationLink.click();
        return page(RegistrationPage.class);
    }

    @Step("Password recovery link click action")
    public PasswordRecoveryPage passwordRecoveryLinkClick() {
        passwordRecoveryLink.click();
        return page(PasswordRecoveryPage.class);
    }

    @Step("Login button click action")
    public MainPage loginButtonClick() {
        loginButton.click();
        return page(MainPage.class);
    }
}