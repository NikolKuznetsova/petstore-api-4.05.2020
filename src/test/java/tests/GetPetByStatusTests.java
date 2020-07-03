package tests;

import Utilities.Randomizer;
import endpoints.PetEndPoints;
import models.Pet;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class GetPetByStatusTests {

    @Steps
    private PetEndPoints petEndPoints;
    private Long petId;
    private String status;

    public GetPetByStatusTests(String status) {
        this.status = status;
    }

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"available"},
                {"sold"},
                {"pending"},
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
