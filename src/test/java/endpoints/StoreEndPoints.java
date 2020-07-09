package endpoints;

import io.restassured.response.ValidatableResponse;
import models.storeModels.Order;
import models.storeModels.Status;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class StoreEndPoints extends BaseClass{

    public final static String PLACE_ORDER = "/store/order",
    FIND_ORDER_BY_ID = "/store/order/{orderId}",
    DELETE_ORDER_BY_ID = "/store/order/{orderId}",
    RETURN_PET_INVENTORY = "/store/inventory";

    /**
     * Method creates new pet.
     *
     * @return
     */
    @Step
    public int placeOrder(Order order) {

        ValidatableResponse response = given()

                .body(order)
                .post(PLACE_ORDER)
                .then()
                .body("status", is(order.getStatus().toString()))
                .statusCode(200);
        return response.extract().path("id");


    }

    @Step
    public void findOrderById(int orderId){
        given()
                .get(FIND_ORDER_BY_ID, orderId)
                .then()
                .body("id", is(orderId))
                .statusCode(200);

    }

    /**
     * Method deletes an existing pet.
     *
     * @param petId pet's id. Id can be set random if it's value will be set to zero
     */
    @Step
    public void deleteOrder(int petId) {
        given()
                .delete(DELETE_ORDER_BY_ID, petId)
                .then()
                .statusCode(200);

    }

    @Step
    public void returnPetsInventoriesByStatus(){
        given()
                .get(RETURN_PET_INVENTORY)
                .then()
                .statusCode(200);
    }
}
