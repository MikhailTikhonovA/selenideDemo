package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasicPage {
    public static final SelenideElement searchBar = $x("//input[@aria-label='Запрос']");
    public static final SelenideElement submitButton = $x("//button[@type='submit']");

}
