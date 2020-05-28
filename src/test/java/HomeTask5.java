import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class HomeTask5 {
    String petId = "1";

    @Test
    public void createPet(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", petId);
        requestParams.put("name", "Cat");
        requestParams.put("photoUrl", "Cat");
        request.body(requestParams.toJSONString());

        Response response = request.post("https://petstore.swagger.io/v2/pet");

        int statusCode = response.getStatusCode();
        System.out.println("The status code recieved: " + statusCode);

        System.out.println("Response body: " + response.body().asString());


    }

    @Test
    public void updatePet(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "1");
        requestParams.put("name", "Dog");
        request.body(requestParams.toJSONString());
        Response response = request.put("https://petstore.swagger.io/v2/pet");

        int statusCode = response.getStatusCode();
        System.out.println("The status code recieved: " + statusCode);

        System.out.println("Response body: " + response.body().asString());
    }

    @Test
    public void deletePet(){
        RestAssured
                .given()// переключает билдер на работу с реквестом
                .log().all() //логируется, распечатывается весь реквест
                .baseUri("https://petstore.swagger.io/v2") //базовая часть урла
                .delete("/pet/"+petId) //параметр урла и метод http - get
                .then() // переключает билдер на работу с респонсом
                .log().all()//логируется, распечатывается весь респонс
                .statusCode(200); //проверка статус кода
    }
}
