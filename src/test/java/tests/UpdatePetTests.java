package tests;

import Utilities.Randomizer;
import endpoints.PetEndPoints;
import models.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdatePetTests extends Randomizer {
    private Long petId;
    private PetEndPoints petEndPoints;

    @Before
    public void before() {
        Pet pet = new Pet(0, Randomizer.getRandomPetName(), Randomizer.getRandomStatus());
        petEndPoints = new PetEndPoints();
        petId = petEndPoints.createPet(pet);

    }

    @Test
    public void updatePet() {
        Pet pet = new Pet(0, Randomizer.getRandomPetName(), Randomizer.getRandomStatus());
        petEndPoints.updatePet(pet);
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }
}
