package tests.PetTests;

import endpoints.PetEndPoints;
import models.petModels.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class DeletePetTests {

    @Steps
    private PetEndPoints petEndPoints;
    private long petId;


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
