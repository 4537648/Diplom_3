package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends MainPage {

    // локатор поля ввода "Имя"
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")
    private SelenideElement nameField;

    // локатор поля ввода "Email"
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input")
    private SelenideElement emailField;

    // локатор поля ввода "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement submitRegistrationButton;

    // локатор гиперссылки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    // локатор сообщения "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement incorrectPassword;

    // локатор сообщения "Такой пользователь уже существует"
    @FindBy(how = How.XPATH, using = ".//a[text()='Такой пользователь уже существует']")
    private SelenideElement existingUser;

    // метод возвращает уведомление о некорректном пароле
    public SelenideElement getIncorrectPassword() {
        return incorrectPassword;
    }

    // метод возвращает уведомление о том, что введенный пользователь уже существует
    public SelenideElement getExistingUser() {
        return existingUser;
    }

    @Step("Login link click action")
    public LoginPage loginLinkClick() {
        loginLink.click();
        return page(LoginPage.class);
    }

    @Step("Registration form filling action")
    public RegistrationPage registrationFormFilling(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        return this;
    }

    @Step("Submit registration button click action")
    public void submitRegistrationButtonClick() {
        submitRegistrationButton.click();
    }
}