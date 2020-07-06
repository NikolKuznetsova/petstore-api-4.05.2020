package tests.PetTests;

import endpoints.PetEndPoints;
import models.petModels.Pet;
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
        petEndPoints.uploadAnImage(petId, "/cat.png");
    }

    @Test
    public void uploadInvalidFile() {
        petEndPoints.uploadAnImage(petId, "/npp.7.6.5.Installer.exe");
    }

}