package tests.StoreTests;

import endpoints.StoreEndPoints;
import models.storeModels.Order;
import models.storeModels.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class PlaceOrderTests {
        @Steps
        private StoreEndPoints storeEndPoints;
        private int orderId;


    @Test
        public void placeOrderToAStore() {
            Order order = Order.builder()
                    .build();
                orderId = storeEndPoints.placeOrder(order);
        }

        @After
        public void after() {

            storeEndPoints.deleteOrder(orderId);
        }



}
