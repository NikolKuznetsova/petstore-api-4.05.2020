package Utilities;

import java.util.Random;

public class Randomizer {


    /**
     * Method selects random value from an Array of pet names
     *
     * @return name value from an array
     */
    protected static String getRandomPetName() {
        String[] petNames = {"Cat", "Dog", "Elephant", "Lion", "Bird"};
        String randomName = (petNames[new Random().nextInt(petNames.length)]);
        return randomName;
    }

    /**
     * Method selects random value from an Array of statuses
     *
     * @return status value from an array
     */
    protected static String getRandomStatus() {
        String[] petNames = {"available", "unavailable"};
        String randomName = (petNames[new Random().nextInt(petNames.length)]);
        return randomName;
    }
}
