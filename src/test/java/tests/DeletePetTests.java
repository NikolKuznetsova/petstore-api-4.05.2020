package tests;

import endpoints.PetEndPoints;
import models.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class DeletePetTests {
    private long petId;

    @Steps
    private PetEndPoints petEndPoints;

    @Before
    public void before() {
        Pet pet = Pet.builder()
                .build();
        petId = petEndPoints.createPet(pet);

    }

    @Test
    public void deletePet() {
        petEndPoints.deletePet(petId);
    }


}
