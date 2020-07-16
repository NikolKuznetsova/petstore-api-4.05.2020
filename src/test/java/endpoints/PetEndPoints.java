package endpoints;

import io.restassured.response.ValidatableResponse;
import models.petModels.Pet;
import models.petModels.Status;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertEquals;

public class PetEndPoints extends BaseEndpoint {

    public final static String CREATE_PET = "/pet",
            UPDATE_PET = "/pet",
            DELETE_PET = "/pet/{petId}",
            GET_PET = "/pet/{petId}",
            GET_PET_BY_STATUS = "/pet/findByStatus/",
            UPLOAD_AN_IMAGE = "/pet/{petId}/uploadImage";


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

    /**
     * Method gets pet by status
     * @param status pet's status
     */
    @Step
    public void getPetByStatus(Status status){
        given()
                .param("status", status)
                .get(GET_PET_BY_STATUS)
                .then()
                //.body("[0].status", is(status.toString()))
               // .body("status", hasItem(allOf(hasProperty("status", is(status.toString())))))
                .body("status", everyItem(is(status.toString())))
                .statusCode(200);
    }

    /**
     * Method creates new pet.
     *
     * @return id and name of created pet
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
     * @return id and name of updated pet
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


    /** Method upload a file
     *
     * @param petId pet's id
     * @param filePath path to the file
     */
    @Step
    public void uploadAnImage(long petId, String filePath){
        File image = new File(getClass().getResource(filePath).getFile());
       given()
                .header("Content-Type", "multipart/form-data")
                .multiPart(image)
                .post(UPLOAD_AN_IMAGE, petId)
                .then()
                .body("message", containsString(image.getName()))
                .statusCode(200);
    }

}

