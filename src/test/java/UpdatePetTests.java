import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdatePetTests extends Utilities {
    private Long petId;
    private PetEndPoints petEndPoints;

    @Before
    public void before() {
        petEndPoints = new PetEndPoints();
        petId = petEndPoints.createPet(0, getRandom());

    }

    @Test
    public void updatePet() {
        petEndPoints.updatePet(0, getRandom());
    }

    @After
    public void after() {
        petEndPoints.deletePet(petId);
    }
}
