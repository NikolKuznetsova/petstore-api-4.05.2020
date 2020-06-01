import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

public class BaseMethods {

    protected static String getRandom() {
        String[] petNames = {"Cat", "Dog", "Elephant", "Lion", "Bird"};
        String randomName = (petNames[new Random().nextInt(petNames.length)]);
        return randomName;
    }

    protected RequestSpecification given() {
        return RestAssured
                .given()
                .log().all()
                .baseUri(PetEndPoints.BASE_URI)
                .contentType("application/json");
    }

    public void deleteRandomPet(Long randomId) {
        given()
                .pathParam("petId", randomId)
                .delete(PetEndPoints.DELETE_PET)
                .then()
                .log().all()
                .statusCode(200);
    }

}
