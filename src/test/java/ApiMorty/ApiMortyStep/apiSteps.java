package ApiMorty.ApiMortyStep;

import Utils.Configuration;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class apiSteps {
    public String charId;
    public String locatMorty;
    public String raceMorty;
    public int lastChar;
    public String raceLastChar;
    public String locatLastChar;
    public String nameLastChar;
    public int lastEpisode;

    @Дано("найдем персонажа Морти Смит")
    public void getCharacter(){
        RequestSpecification request = given();
        Response response=request
                .baseUri(Configuration.getConfigurationValue("Url"))
                .when()
                .get("/character/" +"2")
                .then()
                .log().all()
                .extract()
                .response();
        charId=new JSONObject(response.getBody().asString()).get("id").toString();
    }

    @Когда("^найдем местоположение и рассу этого персонажа")
    public void getCharacterInfo() {
        RequestSpecification request = given();
        Response response = request
                .baseUri(Configuration.getConfigurationValue("Url"))
                .when()
                .get("/character/" + charId)
                .then()
                .log().all()
                .extract()
                .response();

        locatMorty = new JSONObject(response.getBody().asString()).getJSONObject("location").get("name").toString();
        raceMorty = new JSONObject(response.getBody().asString()).get("species").toString();
        System.out.println(charId);
        System.out.println(locatMorty);
        System.out.println(raceMorty);
    }

    //Ищем последний эпизод, где появлялся Морти.
    @И("^найдем послежний эпизод, в котором он был")
    public void getLastEpisode(){
        RequestSpecification request = given();
        Response response=request
                .baseUri(Configuration.getConfigurationValue("Url"))
                .when()
                .get("/character/" +charId)
                .then()
                .log().all()
                .extract()
                .response();
        int episode = new JSONObject(response.getBody().asString()).getJSONArray("episode").length()-1;//получаем индекс последнего элемента массива эпизодов
        System.out.println(episode);

        String lepis = new JSONObject(response.getBody().asString()).getJSONArray("episode").get(episode).toString();//получаем значение элемента для последнего эпизода
        System.out.println(lepis);

        lastEpisode = Integer.parseInt(lepis.replaceAll("[^0-9]",""));//получаем номер эпизода (отрезаем лишнее от ссылки)
        System.out.println(lastEpisode);
    }

    //Ищем из последнего эпизода последнего персонажа.
    @И("^найдем id персонажа последнего эпизода")
    public void getLastCharacter(){
        RequestSpecification request = given();
        Response response=request
                .baseUri(Configuration.getConfigurationValue("Url"))
                .when()
                .get("/episode/" +lastEpisode)
                .then()
                .log().all()
                .extract()
                .response();
        int lastCharIndex = new JSONObject(response.getBody().asString()).getJSONArray("characters").length()-1;//получаем индекс последнего элемента массива персонажей в последем эпизоде
        System.out.println(lastCharIndex);

        String lchar = new JSONObject(response.getBody().asString()).getJSONArray("characters").get(lastCharIndex).toString();//получаем значение элемента для последнего персонажа
        System.out.println(lchar);

        lastChar = Integer.parseInt(lchar.replaceAll("[^0-9]",""));//получаем id последнего персонажа
        System.out.println(lastChar);
    }

    //Ищем информацию по последнему персонажу последнего эпизода.

    @И("^определим местоположение и рассу последнего персонажа последнего эпизода")
    public void getLastCharInfo(){
        RequestSpecification request = given();
        Response response=request
                .baseUri(Configuration.getConfigurationValue("Url"))
                .when()
                .get("/character/" +lastChar)
                .then()
                .log().all()
                .extract()
                .response();
        raceLastChar=new JSONObject(response.getBody().asString()).get("species").toString();
        locatLastChar=new JSONObject(response.getBody().asString()).getJSONObject("location").get("name").toString();
        nameLastChar=new JSONObject(response.getBody().asString()).get("name").toString();
        System.out.println(nameLastChar);
        System.out.println(lastChar);
        System.out.println(raceLastChar);
        System.out.println(locatLastChar);
    }

    //Сравнение местоположения и рассы последнего персонажа с Морти
    @Тогда("^сравниваем рассы этих персонажей")
    public void AssertRace(){Assertions.assertEquals(raceMorty,raceLastChar,"Данные не соотвествуют");}
    @И("^сравниваем местоположение этих персонажей")
    public void AssertLoc(){Assertions.assertEquals(locatMorty,locatLastChar,"Данные не соотвествуют");}
}
