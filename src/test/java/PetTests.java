import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;


public class PetTests extends BaseMethods {
    int petId = 1;
    String petToCreate = "Cat";
    String petToUpdate = "Dog";
    Long randomId;

    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!method.getName().equals("createPet")) {
            JSONObject requestParams = new JSONObject();
            requestParams.put("id", petId);
            requestParams.put("name", petToCreate);

            given()

                    .body(requestParams.toJSONString())
                    .post(PetEndPoints.CREATE_PET)
                    .then()
                    .body("id", (is(petId)))
                    .body("name", (is(petToCreate)))
                    .statusCode(200);
        }


    }


    @Test
    public void getPetById() {
        given()
                .pathParam("petId", petId)
                .get(PetEndPoints.GET_PET)
                .then()
                .log().all()
                .body("id", anyOf(is(petId), is(2)))
                .statusCode(200);
    }

    @Test
    public void createPet() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", 0);
        requestParams.put("name", getRandom());

        randomId = given()

                .body(requestParams.toJSONString())
                .post(PetEndPoints.CREATE_PET)
                .then()
                .log().all()
                .body("name", anyOf(is("Cat"), is("Dog"), is("Elephant"), is("Lion"), is("Bird")))
                .statusCode(200)
                .extract()
                .path("id");

        deleteRandomPet(randomId);
    }

    @Test
    public void updatePet() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", petId);
        requestParams.put("name", petToUpdate);

        given()
                .body(requestParams.toJSONString())
                .put(PetEndPoints.UPDATE_PET)
                .then()
                .body("id", (is(petId)))
                .body("name", (is(petToUpdate)))
                .statusCode(200);
        System.out.println("test");

    }

    @Test
    public void deletePet() {
        given()
                .pathParam("petId", petId)
                .delete(PetEndPoints.DELETE_PET)
                .then()
                .log().all()
                .statusCode(200);
    }

    @AfterMethod
    public void afterMethod(Method method) {
        if (!method.getName().equals("createPet") && !method.getName().equals("deletePet")) {
            given()
                    .pathParam("petId", petId)
                    .delete(PetEndPoints.DELETE_PET)
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    }


}
