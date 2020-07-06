package tests;

import Utilities.Randomizer;
import endpoints.PetEndPoints;
import models.Pet;
import models.Status;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static models.Status.*;

@RunWith(SerenityParameterizedRunner.class)
public class GetPetByStatusTests {

    @Steps
    private PetEndPoints petEndPoints;
    private Long petId;
    private Status status;

    public GetPetByStatusTests(Status status) {
        this.status = status;
    }

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {available},
                {SOLD},
                {PENDING},
        });
    }


    @Before
    public void before() {
        Pet pet = Pet.builder()
                .id(0)
                .name(Randomizer.getRandomPetName())
                .status(status)
                .build();
        petId = petEndPoints.createPet(pet);

    }

    @Test
    public void getPetById() {
        petEndPoints.getPetByStatus(status);
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }
}
