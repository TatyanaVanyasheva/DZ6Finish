package UiJira.Steps;

import UiJira.Elements.Main;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
public class MainSteps extends Main{
    @Когда("^Переходим к проекту")
    public static void MainMethod(){
        proj.shouldBe(visible, Duration.ofSeconds(60)).click();
        testProj.shouldBe(visible, Duration.ofSeconds(60)).click();
        taskProj.shouldBe(visible, Duration.ofSeconds(60)).click();
    }
    @Тогда("^Проверяем количеcтво задач")
    public static void QuantityTask(){
        String numberTask=numbProj.getText();
        System.out.println("Колличество задач всего: "+numberTask);
    }
}
