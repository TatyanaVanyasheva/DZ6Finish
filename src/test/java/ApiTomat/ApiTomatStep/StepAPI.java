package ApiTomat.ApiTomatStep;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StepAPI {

    public JSONObject body;

    @Когда("^Считываем данные из файла")
    public void readJSON() throws IOException {
        body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/JSON/test.json"))));
    }
    @Тогда("^Изменяем данные в json-объекте")
    public void putBody() {
        body.put("name", "Tomato");
        body.put("job", "Eat market");
    }
    @Затем("^Оправляем строку запроса на сервер и проверяем данные")
    public void requestBody() {
        RequestSpecification request = given();
        request
                .baseUri(Utils.Configuration.getConfigurationValue("baseUrl"))
                .header("Content-type", "application/json")
        ;

        Response response = request
                .body(body.toString())
                .when()
                .post("/users")
                .then()
                .extract()
                .response();

        int statusCod = response.statusCode();
        Assertions.assertEquals(statusCod, 201, "Статус код неверный");
        Assertions.assertEquals((new JSONObject(response.getBody().asString()).get("name")), (body.get("name")), "Не соответствует");
        Assertions.assertEquals((new JSONObject(response.getBody().asString()).get("job")), (body.get("job")), "Не соответствует");
    }
}
