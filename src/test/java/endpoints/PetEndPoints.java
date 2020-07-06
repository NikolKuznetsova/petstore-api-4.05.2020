package endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.Pet;
import models.Status;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.yecht.Data;

import java.io.File;
import java.sql.Statement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class PetEndPoints {

    public final static String BASE_URI = "https://petstore.swagger.io/v2",
            CREATE_PET = "/pet",
            UPDATE_PET = "/pet",
            DELETE_PET = "/pet/{petId}",
            GET_PET = "/pet/{petId}",
            GET_PET_BY_STATUS = "/pet/findByStatus/",
            UPLOAD_AN_IMAGE = "/pet/{petId}/uploadImage";

    static {
        SerenityRest.filters(new RequestLoggingFilter(LogDetail.ALL));
        SerenityRest.filters(new ResponseLoggingFilter(LogDetail.ALL));
    }
    /**
     * Method makes a request to a base URI, collect logs and set headers
     *
     * @return base URI, logs, headers
     */
    protected RequestSpecification given() {
        return SerenityRest
                .given()
                .baseUri(BASE_URI)
                .contentType("application/json");
    }

    /**
     * Method gets pet by it's ID
     *
     * @param petId pet's id. Id can be set random if it's value will be set to zero
     */
    @Step
    public long getPet(long petId) {
        ValidatableResponse response = given()
                .get(GET_PET, petId)
                .then()
                .statusCode(200);
        return response.extract().path("id", "name");

    }

    @Step
    public void getPetByStatus(Status status){
        given()
                .param("status", status)
                .get(GET_PET_BY_STATUS)
                .then()
                .body("[0].status", is(status.toString()))
                .statusCode(200);
    }

    /**
     * Method creates new pet.
     *
     * @return
     */
    @Step
    public long createPet(Pet pet) {

        ValidatableResponse response = given()

                .body(pet)
                .post(CREATE_PET)
                .then()
                .body("name", is(pet.getName()))
                .statusCode(200);
        return response.extract().path("id", "name");


    }

    /**
     * Method updates an existing pet.
     *
     * @return
     */
    @Step
    public long updatePet(Pet pet) {
        ValidatableResponse response = given()
                .body(pet)
                .put(UPDATE_PET)
                .then()
                .body("name", is(pet.getName()))
                .statusCode(200);
        return response.extract().path("id", "name");

    }

    /**
     * Method deletes an existing pet.
     *
     * @param petId pet's id. Id can be set random if it's value will be set to zero
     */
    @Step
    public String deletePet(long petId) {
        ValidatableResponse response = given()
                .pathParam("petId", petId)
                .delete(DELETE_PET)
                .then()
                .statusCode(200);
        return response.extract().path("message");

    }


    @Step
    public String uploadAnImage(long petId, String filePath){
        File image = new File(getClass().getResource(filePath).getFile());
        ValidatableResponse response = given()
                .header("Content-Type", "multipart/form-data")
                .multiPart(image)
                .post(UPLOAD_AN_IMAGE, petId)
                .then()
                .body("message", containsString(image.getName()))
                .statusCode(200);
        return response.extract().body().asString();
    }

}

