import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreatePetTests extends Utilities {
    private Long petId;
    private PetEndPoints petEndPoints;

    @Before
    public void before() {
        petEndPoints = new PetEndPoints();
    }

    @Test
    public void createPet() {
        petId = petEndPoints.createPet(0, getRandom());
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }


}
