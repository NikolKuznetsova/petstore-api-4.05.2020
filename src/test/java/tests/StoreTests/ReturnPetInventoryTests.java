package tests.StoreTests;

import endpoints.PetEndPoints;
import endpoints.StoreEndPoints;
import models.petModels.Pet;
import models.petModels.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class ReturnPetInventoryTests {
    private long petId;

    @Steps
    private StoreEndPoints storeEndPoints;
    @Steps
    private PetEndPoints petEndPoints;


    @Before
    public void before() {
        Pet pet = Pet.builder()
                .status(Status.MYTEST)
                .build();
        petId = petEndPoints.createPet(pet);

    }

    @Test
    public void returnInventoryByStatus() {
        storeEndPoints.returnPetsInventoriesByStatus();


    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }


}
