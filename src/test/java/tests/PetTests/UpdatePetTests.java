package tests.PetTests;

import utilities.Randomizer;
import endpoints.PetEndPoints;
import models.petModels.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static models.petModels.Status.SOLD;

@RunWith(SerenityRunner.class)
public class UpdatePetTests {
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
    public void updatePet() {
        Pet pet = Pet.builder()
                .id(petId)
                .name(Randomizer.getRandomPetName())
                .status(SOLD)
                .build();
        petEndPoints.updatePet(pet);
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }
}
