package endpoints;

import io.restassured.response.ValidatableResponse;
import models.petModels.Status;
import models.storeModels.Order;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static models.petModels.Status.MYTEST;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertThat;

public class StoreEndPoints extends BaseEndpoint {

    public final static String PLACE_ORDER = "/store/order",
            FIND_ORDER_BY_ID = "/store/order/{orderId}",
            DELETE_ORDER_BY_ID = "/store/order/{orderId}",
            RETURN_PET_INVENTORY = "/store/inventory";

    /**
     * Method places new order
     *
     * @param order Model of order that includes all necessary fields
     * @return returns id of created order
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

    /**
     * Method gets order by id
     *
     * @param orderId id of order
     */
    @Step
    public void findOrderById(int orderId) {
        given()
                .get(FIND_ORDER_BY_ID, orderId)
                .then()
                .body("id", is(orderId))
                .statusCode(200);

    }

    /**
     * Method deletes an existing order.
     *
     * @param orderId id of order
     */
    @Step
    public void deleteOrder(int orderId) {
        given()
                .delete(DELETE_ORDER_BY_ID, orderId)
                .then()
                .statusCode(200);

    }

    /**
     * Method gets all returned inventories by status
     *
     * @return
     */
    @Step
    public ValidatableResponse returnPetsInventoriesByStatus() {
        return given()
                .get(RETURN_PET_INVENTORY)
                .then()
                .body("$", Matchers.is(hasKey("MYTEST")))
                .statusCode(200);
    }
}
