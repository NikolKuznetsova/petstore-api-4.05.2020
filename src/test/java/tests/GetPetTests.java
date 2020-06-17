package tests;

import Utilities.Randomizer;
import endpoints.PetEndPoints;
import models.Category;
import models.Pet;
import models.Tags;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class GetPetTests {
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
    public void getPetById() {
        petEndPoints.getPet(petId);
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }
}
