package utilities;

import java.util.Random;

public class Randomizer {


    /**
     * Method selects random value from an Array of pet names
     *
     * @return name value from an array
     */
    public static String getNameFromList() {
        String[] petNames = {"Cat", "Dog", "Elephant", "Lion", "Bird"};
        String randomName = (petNames[new Random().nextInt(petNames.length)]);
        return randomName;
    }

    /**
     * Method selects random value from an Array of statuses
     *
     * @return status value from an array
     */

    public static int getOneOfTenNumbersFromList(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int randomId = (numbers[new Random().nextInt(numbers.length)]);
                return randomId;
    }

    public static boolean add(){
        boolean[] meanings = {true, false};
        boolean randomMeaning = (meanings[new Random().nextInt(meanings.length)]);
        return randomMeaning;
    }
}
