package UiJira.Steps;

import UiJira.Elements.Login;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginSteps extends Login {
    @Дано ("^открываем главную страницу Jira: \"([^\"]*)\"")
    public static void openUrl(String Url){open(Url);
    }
    @Когда("^Авторизуемся на сайте")
        public static void loginMethod(List<String> arg) {
        String  log = arg.get(0);
        String  pass = arg.get(1);

        login.shouldBe(Condition.visible).sendKeys(log);
        password.shouldBe(Condition.visible).sendKeys(pass);
        loginIn.shouldBe(Condition.enabled).click();

        //проверка на ошибку входа
        String elemVal = assertPR.shouldBe(visible,Duration.ofSeconds(60) ).getText();
        Assertions.assertEquals(elemVal, "System Dashboard", "Ошибка ввода");
        }
}