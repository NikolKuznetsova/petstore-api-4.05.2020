import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static org.hamcrest.CoreMatchers.is;

public class PetEndPoints {

    public final static String BASE_URI = "https://petstore.swagger.io/v2",
            CREATE_PET = "/pet",
            UPDATE_PET = "/pet",
            DELETE_PET = "/pet/{petId}",
            GET_PET = "/pet/{petId}";

    /**
     * Method makes a request to a base URI, collect logs and set headers
     *
     * @return base URI, logs, headers
     */
    protected RequestSpecification given() {
        return RestAssured
                .given()
                .log().all()
                .baseUri(BASE_URI)
                .contentType("application/json");
    }

    /**
     * Method gets pet by it's ID
     *
     * @param petId pet's id. Id can be set random if it's value will be set to zero
     */

    public Long getPet(long petId) {
        ValidatableResponse response = given()
                .pathParam("petId", petId)
                .get(GET_PET)
                .then()
                .log().all()
                .statusCode(200);
        return response.extract().path("id", "name");

    }

    /**
     * Method creates new pet.
     *
     * @param petId   pet's id. Id can be set random if it's value will be set to zero
     * @param petName pet's name. Name can be set random if method Utilities.getRandom() will be called
     * @return
     */
    public Long createPet(long petId, String petName) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", petId);
        requestParams.put("name", petName);

        ValidatableResponse response = given()

                .body(requestParams.toJSONString())
                .post(CREATE_PET)
                .then()
                .log().all()
                .body("name", is(petName), "id", is(petId))//ToDo: исправить проверку petId
                .statusCode(200);
        return response.extract().path("id", "name");



    }

    /**
     * Method updates an existing pet.
     *
     * @param petId   pet's id. Id can be set random if it's value will be set to zero
     * @param petName pet's name. Name can be set random if method Utilities.getRandom() will be called
     * @return
     */
    public Long updatePet(int petId, String petName) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", petId);
        requestParams.put("name", petName);

        ValidatableResponse response = given()
                .body(requestParams.toJSONString())
                .put(UPDATE_PET)
                .then()
                .body("name", (is(petName)))
                .statusCode(200);
        return response.extract().path("id", "name");

    }

    /**
     * Method deletes an existing pet.
     *
     * @param petId pet's id. Id can be set random if it's value will be set to zero
     */
    public String deletePet(long petId) {
        ValidatableResponse response = given()
                .pathParam("petId", petId)
                .delete(DELETE_PET)
                .then()
                .log().all()
                .statusCode(200);
        return response.extract().path("message");

    }
}
