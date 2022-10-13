package ApiTomat;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"ApiTomat.ApiTomatStep", "Utils"},
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        features = "src/test/resources/feature",
        tags = "@TEST1",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
    @BeforeClass
    public static void before()
    {
        RestAssured.filters( new AllureRestAssured());
    }
}