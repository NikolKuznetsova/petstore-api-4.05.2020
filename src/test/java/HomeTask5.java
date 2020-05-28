import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomeTask5 {
    String petId = "1";
    String petToCreate = "Cat";
    String petToUpdate = "Dog";
    String baseUrl = "https://petstore.swagger.io/v2";
    String petUrl = "https://petstore.swagger.io/v2/pet";

    @Test
    public void createPet(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", petId);
        requestParams.put("name", petToCreate);
        request.body(requestParams.toJSONString());

        Response response = request.post(petUrl);

        int statusCode = response.getStatusCode();
        System.out.println("The status code recieved: " + statusCode);
        System.out.println("Response body: " + response.body().asString());

        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains(petToCreate));

    }


    @Test
    public void updatePet(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id", petId);
        requestParams.put("name", petToUpdate);
        request.body(requestParams.toJSONString());

        Response response = request.put(petUrl);

        int statusCode = response.getStatusCode();
        System.out.println("The status code recieved: " + statusCode);
        System.out.println("Response body: " + response.body().asString());

        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains(petToUpdate));

    }

    @Test
    public void deletePet(){
        RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .delete("/pet/"+petId)
                .then()
                .log().all()
                .statusCode(200);
    }

}
