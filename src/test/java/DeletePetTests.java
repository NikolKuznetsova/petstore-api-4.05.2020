import org.junit.Before;
import org.junit.Test;

public class DeletePetTests extends Utilities {
    private Long petId;
    private PetEndPoints petEndPoints;

    @Before
    public void before() {
        petEndPoints = new PetEndPoints();
        petId = petEndPoints.createPet(0, getRandom());

    }

    @Test
    public void deletePet() {
        petEndPoints.deletePet(petId);
    }


}
