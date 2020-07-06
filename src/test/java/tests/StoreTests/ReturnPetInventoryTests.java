package tests.StoreTests;

import endpoints.StoreEndPoints;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ReturnPetInventoryTests {

    @Steps
    private StoreEndPoints storeEndPoints;
    private int orderId;

    @Test
    public void returnInventoryByStatus(){
        storeEndPoints.returnPetsInventoriesByStatus();

    }

}
