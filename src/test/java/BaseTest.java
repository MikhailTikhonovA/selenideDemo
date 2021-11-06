import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import paths.BasicPaths;
import steps.BasicSteps;

import static io.qameta.allure.Allure.step;
import static pages.BasicPage.searchBar;
import static pages.BasicPage.submitButton;

@Owner("Mikhail")
@DisplayName("test")
public class BaseTest {

    private final BasicSteps steps = new BasicSteps();

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Feature("searching")
    @Story("search")
    @Test
    void doSmth() {
        step("Открыть главную страницу", () -> {
            Selenide.open(BasicPaths.mainPage);
        });

        step("Ввести в поиск Selenium", () -> {
            searchBar.sendKeys("selenium");
        });

        step("Подтвердить запрос", (Allure.ThrowableRunnableVoid) submitButton::click);
    }

    @Feature("searching")
    @Story("search")
    @Test
    void doSmth2() {
        steps.openMainPage();
        steps.searchText("text");
        steps.submitDecision();
    }

}
