package tests.StoreTests;

import endpoints.StoreEndPoints;
import models.storeModels.Order;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FindPurchasedOrderByIdTests {
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
    public void getOrderById() {
        storeEndPoints.findOrderById(orderId);
    }

    @After
    public void after() {
        storeEndPoints.deleteOrder(orderId);
    }
}
