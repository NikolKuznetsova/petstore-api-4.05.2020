package tests;

import endpoints.PetEndPoints;
import models.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CreatePetTests {
    private long petId;
    @Steps
    private PetEndPoints petEndPoints;

    @Test
    public void createPet() {
        Pet pet = Pet.builder()
                .build();
        petEndPoints.createPet(pet);
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }


}
