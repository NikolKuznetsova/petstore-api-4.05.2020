import java.util.Random;

public class Utilities {

    /**
     * Method selects random value from an Array of pet names
     *
     * @return name value from an array
     */
    protected static String getRandom() {
        String[] petNames = {"Cat", "Dog", "Elephant", "Lion", "Bird"};
        String randomName = (petNames[new Random().nextInt(petNames.length)]);
        return randomName;
    }

}
