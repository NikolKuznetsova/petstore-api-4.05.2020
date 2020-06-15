package tests;

import Utilities.Randomizer;
import endpoints.PetEndPoints;
import models.Category;
import models.Pet;
import models.Tags;
import org.junit.Before;
import org.junit.Test;

public class DeletePetTests {
    private long petId;
    private PetEndPoints petEndPoints = new PetEndPoints();
    private String[]urls = new String[]{"https://media.nature.com/lw800/magazine-assets/d41586-020-01443-0/d41586-020-01443-0_17985512.jpg", "https://cs4.pikabu.ru/post_img/big/2014/05/21/5/1400654986_1651578960.jpg"};

    @Before
    public void before() {
        Pet pet = Pet.builder()
                .id(0)
                .name(Randomizer.getRandomPetName())
                .status(Randomizer.getRandomStatus())
                .photoUrls(urls)
                .category(Category.builder().id(1).name("domestic pets").build())
                .tags(new Tags[]{Tags.builder().id(1).name("domestic pets").build()})
                .build();
        petId = petEndPoints.createPet(pet);

    }

    @Test
    public void deletePet() {
        petEndPoints.deletePet(petId);
    }


}
