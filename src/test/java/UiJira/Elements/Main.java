package UiJira.Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Main {
    public static SelenideElement proj = $x("//a[contains(@title, 'Просмотр недавних')]");
    public static SelenideElement testProj = $x("//a[contains(@title,'Просмотр недавних')]//following-sibling::div//a[contains(@href,'TEST')]");
    public static SelenideElement taskProj = $x("//span[contains(@class,'aui-iconfont-issues')]");
    public static SelenideElement numbProj = $x("//span[starts-with(text(),'1')]");
}

