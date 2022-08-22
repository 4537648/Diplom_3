package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    // локатор кнопки "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement accountButton;

    // локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    // локатор кнопки логотипа "Stellar Burgers"
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarBurgersLogo;

    // локатор звголовка "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement constructBurgerHeader;

    // локатор кнопки перехода в раздел "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    // локатор кнопки перехода в раздел "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceButton;

    // локатор кнопки перехода в раздел "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingButton;

    // локатор названия блока "Булки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsHeader;

    // локатор названия блока "Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement sauceHeader;

    // локатор названия блока "Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingHeader;

    // локатор элемента выбранного блока конструктора
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    private SelenideElement selectedBlock;

    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginMainButton;

    // локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement completeOrderButton;

    // метод возвращает элемент выбранного блока
    public SelenideElement getSelectedBlock() {
        return selectedBlock;
    }

    // метод возвращает элемент блока "Булки"
    public SelenideElement getBunsHeader() {
        return bunsHeader;
    }

    // метод возвращает элемент блока "Соусы"
    public SelenideElement getSauceHeader() {
        return sauceHeader;
    }

    // метод возвращает элемент блока "Начинки"
    public SelenideElement getFillingHeader() {
        return fillingHeader;
    }

    // метод возвращает локатор кнопки "Оформить заказ"
    public SelenideElement getCompleteOrderButton() {
        return completeOrderButton;
    }

    // метод возвращает локатор кнопки "Оформить заказ"
    public SelenideElement getConstructBurgerHeader() {
        return constructBurgerHeader;
    }

    @Step("Account button click action")
    public LoginPage accountButtonClick() {
        accountButton.click();
        return page(LoginPage.class);
    }

    @Step("Login button click action")
    public LoginPage loginMainButtonClick() {
        loginMainButton.click();
        return page(LoginPage.class);
    }


    @Step("Constructor button click action")
    public MainPage constructorButtonClick() {
        constructorButton.click();
        return this;
    }

    @Step("Buns button click action")
    public MainPage bunsButtonClick() {
        bunsButton.click();
        return this;
    }
    @Step("Sauce button click action")
    public MainPage sauceButtonClick() {
        sauceButton.click();
        return this;
    }

    @Step("Filling button click action")
    public MainPage fillingButtonClick() {
        fillingButton.click();
        return this;
    }

    @Step("Stellar Burgers logo click action")
    public void stellarBurgersLogoClick() {
        stellarBurgersLogo.click();
    }
}