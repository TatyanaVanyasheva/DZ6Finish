package UiJira.Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Proj {
    public static SelenideElement search = $x("//input[@placeholder='Поиск']");
    public static SelenideElement status=$x("//strong[contains(text(),'Статус:')]//following-sibling::span");
    public static SelenideElement version=$x("//strong[@title='Исправить в версиях']//following-sibling::span");

}
