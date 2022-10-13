package UiJira.Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Login {
    public static SelenideElement login = $x ("//input[@name='os_username']");
    public static SelenideElement password = $x("//input[@name='os_password']");
    public static SelenideElement loginIn = $x("//input[@value='Войти']");
    public static SelenideElement assertPR = $x ("//h1");
}
