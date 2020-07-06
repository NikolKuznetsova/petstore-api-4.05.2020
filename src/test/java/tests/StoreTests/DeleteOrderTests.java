package tests.StoreTests;

import endpoints.StoreEndPoints;
import models.storeModels.Order;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class DeleteOrderTests {
    @Steps
    private StoreEndPoints storeEndPoints;
    private int orderId;

    @Before
    public void before() {
        Order order = Order.builder()
                .build();
        orderId = storeEndPoints.placeOrder(order);

    }

    @Test
    public void deleteOrder(){
        storeEndPoints.deleteOrder(orderId);
    }

}
