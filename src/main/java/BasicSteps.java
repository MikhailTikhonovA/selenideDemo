import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BasicSteps {
    private static final SelenideElement searchBar = $x("//input[@aria-label='Запрос']");
    private static final SelenideElement submitButton = $x("//button[@type='submit']");

    @Step("Открыть главную страницу")
    public void openMainPage(){
        Selenide.open(BasicPaths.mainPage);
    }

    @Step("Ввести в поиск Selenium")
    public void searchText(String name){
        searchBar.sendKeys(name);
    }

    @Step("Подтвердить запрос")
    public void submitDecision(){
        submitButton.click();
    }

}
