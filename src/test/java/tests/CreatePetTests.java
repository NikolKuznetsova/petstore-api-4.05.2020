package tests;

import Utilities.Randomizer;
import endpoints.PetEndPoints;
import models.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreatePetTests extends Randomizer {
    private Long petId;
    private PetEndPoints petEndPoints;

    @Before
    public void before() {
        petEndPoints = new PetEndPoints();
    }

    @Test
    public void createPet() {
        Pet pet = new Pet(0, Randomizer.getRandomPetName(), Randomizer.getRandomStatus());
        petId = petEndPoints.createPet(pet);
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }


}
