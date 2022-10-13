package UiJira.Steps;

import UiJira.Elements.Task;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;

public class TaskSteps extends Task {
    @Когда( "Нажимаем кнопку \"Создать\"")
    public static void CreatTask() {
        create.click();
        createTask.shouldBe(visible, Duration.ofSeconds(60));
    }
    @Тогда("^В открывшемся окне: \"Создать задачу\", описываем новую задачу и создаем её")
    public static void TaskMethod() {
        Type.shouldBe(visible, Duration.ofSeconds(60)).click();
        Type.sendKeys("Ошибка");
        Type.pressEnter();
        tema.setValue("Название ошибки программы");
        descripTask.click();
        switchTo().frame(descripTask);
        fildFrame.setValue("Какой-то комментарий");
        switchTo().defaultContent();
        envirTask.click();
        switchTo().frame(envirTask);
        fildFrame.setValue("сетевое окружение");
        switchTo().defaultContent();
        versEdit.scrollIntoView(true).click();
        versTouch.scrollIntoView(true).click();
        assign.click();
        btnCreate.click();
    }
    @И("^Проводим задачу по статусам до \"([^\"]*)\"$")
        public static void StatusTask(String StatusTask){
        allTask.click();
        myTask.shouldBe(visible, Duration.ofSeconds(60)).click();
        error.shouldBe(visible, Duration.ofSeconds(60)).click();
        btnWork.shouldBe(visible, Duration.ofSeconds(60)).click();
        Selenide.sleep(1000);
        String statusZad=statusVal.getText();

        Assertions.assertEquals(statusZad, "В РАБОТЕ", "ошибка");

        busnsPr.shouldBe(visible, Duration.ofSeconds(60)).click();
        busnsPrVp.shouldBe(visible, Duration.ofSeconds(60)).click();

        Selenide.sleep(1000);

        String statusZad1=statusVal.getText();
        Assertions.assertEquals(statusZad1, StatusTask, "ошибка");
    }
}
