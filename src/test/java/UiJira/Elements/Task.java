package UiJira.Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Task {
    public static SelenideElement Type=$x("//input[@id='issuetype-field']");
    public static SelenideElement tema=$x("//input[@name='summary']");
    public static SelenideElement descripTask=$x("//div[@id='description-wiki-edit']//iframe");
    public static SelenideElement fildFrame=$x("//p");
    public static SelenideElement envirTask=$x("//div[@id='environment-wiki-edit']//iframe");
    public static SelenideElement versEdit=$x("(//option[@value='10001'])[1]");
    public static SelenideElement versTouch=$x("(//option[@value='10001'])[2]");
    public static SelenideElement btnCreate=$x("//input[@value='Создать']");
    public static SelenideElement assign=$x("//button[contains(text(), 'Назначить меня')]");
    public static SelenideElement btnWork=$x("//span[(text()='В работе')]");
    public static SelenideElement busnsPr=$x("//span[(text()='Бизнес-процесс')]");
    public static SelenideElement busnsPrVp=$x("//span[text()='Выполнено']");
    public static SelenideElement allTask=$x("//a[contains(@title,'Поиск и просмотр')]");
    public static SelenideElement myTask=$x("//a[contains(text(),'Мои открытые задачи')]");
    public static SelenideElement error=$x("//li[@title='Название ошибки программы']");
    public static SelenideElement statusVal=$x("//span[contains(@class, 'jira-issue-status-lozenge')]");
    public static SelenideElement create=$x("//a[contains(text(),'Создать')]");
    public static SelenideElement createTask=$x("//h2[text()='Создание задачи']");
}
