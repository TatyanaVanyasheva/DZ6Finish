package UiJira.Steps;

import UiJira.Elements.Proj;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class ProjSteps extends Proj {
    @Когда ("В поиске ищем задачу \"([^\"]*)\" и переходим в неё$")
    public static void ProjMethod(String TaskName) {
        search.shouldBe(visible, Duration.ofSeconds(60));
        search.setValue(TaskName).pressEnter();
    }
    @Тогда ("Проверяем статус: \"([^\"]*)\"$")
        public static void StatusTask(String stat) {
        String statZ = status.getText();
        System.out.println("Статус задачи:" + statZ);
        Assertions.assertEquals(statZ, stat, "ошибка");
    }
    @И ("Привязку к версии: \"([^\"]*)\"$")
        public static void VersionTask(String vers) {
        String versZ = version.getText();
        System.out.println("Версия:" + versZ);
        Assertions.assertEquals(versZ, vers, "ошибка");
        }
    }
