import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetPetTests extends Utilities {
    private Long petId;
    private PetEndPoints petEndPoints;

    @Before
    public void before() {
        petEndPoints = new PetEndPoints();
        petId = petEndPoints.createPet(0, getRandom());

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
