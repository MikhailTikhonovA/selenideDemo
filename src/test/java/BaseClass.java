import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

@Owner("Mikhail")
@DisplayName("test")
public class BaseClass {
    private static final SelenideElement searchBar = $x("//input[@aria-label='Запрос']");
    private static final SelenideElement submitButton = $x("//button[@type='submit']");

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
