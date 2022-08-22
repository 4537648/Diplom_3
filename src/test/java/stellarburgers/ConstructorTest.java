package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;

@DisplayName("Constructor cases")
public class ConstructorTest extends Common {
    @Before
    public void setUp() {
        mainPage.constructorButtonClick();
    }

    @Test
    @DisplayName("Buns category opening")
    public void bunsCategoryOpening() throws InterruptedException {
        mainPage.sauceButtonClick();
        Thread.sleep(500);
        mainPage.bunsButtonClick();
        mainPage.getSelectedBlock().shouldHave(text("Булки"));
    }

    @Test
    @DisplayName("Sauces category opening")
    public void sauceCategoryOpening() {
        mainPage.sauceButtonClick()
                .getSelectedBlock().shouldHave(text("Соусы"));
    }

    @Test
    @DisplayName("Filling category opening")
    public void fillingCategoryOpening() {
        mainPage.fillingButtonClick()
                .getSelectedBlock().shouldHave(text("Начинки"));
    }
}