package tests;

import endpoints.PetEndPoints;
import models.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UploadImageTests {
    @Steps
    private PetEndPoints petEndPoints;
    private Long petId;

    @Before
    public void before() {
        Pet pet = Pet.builder()
                .build();
        petId = petEndPoints.createPet(pet);

    }


    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }

    @Test
    public void uploadValidFile() {
        petEndPoints.uploadAnImage(petId, "C:\\AutoTests\\petstore-api-4.05.2020\\src\\test\\resources\\cat.png");
    }

    @Test
    public void uploadInvalidFile() {
        petEndPoints.uploadAnImage(petId, "C:\\Users\\qa.autotest\\Desktop\\file.pdf");
    }

}