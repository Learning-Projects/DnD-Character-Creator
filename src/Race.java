import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Race is a superclass to all the various race classes in D&D 5E
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */
public class Race {
    // Attributes that every race will possess
    protected String name;
    protected String size = "error";    // "Small", "Medium", or "Large"
    protected int speed = -1;      // Your normal walking speed in feet

    /**
     * Constructs the basic class object from the defined values
     * @param name The name of the race e.g. "Dwarf"
     */
    public Race(String name) {
        this.name = name;   // Assign the name attribute

        /**
         * Attempt to retrieve this particular race's statistics while catching exceptions
         */
        try {
            retrieveValues(name);   // Call method to retrieve values
        } catch (IOException e) {   // Catch exception
            System.out.println("Error: could not retrieve values.");
        }
    }

    /**
     * Retrieves the size and speed values for the relevant race when it is constructed.
     * @param name The name of the race which is searched for in the values file
     * @throws IOException Throws exception if values were not able to be found
     */
    private void retrieveValues(String name) throws IOException {
        File raceFile = new File("Resources/RaceValues.txt"); // Create the race file object
        Scanner in = null;

        /**
         * Try to read from file, catch potentual exception
         */
        try {
            in = new Scanner(raceFile); // Read from file
        } catch (FileNotFoundException e) { // Catch exception
            System.out.println("Error: could not locate file.");
        }

        /**
         * Check each line in file until the name matches, then extract values
         */
        if (in != null) {
            while (in.hasNextLine()) {  // Check each line
                String curLine = in.nextLine();
                Scanner lineScan = new Scanner(curLine);
                if (lineScan.next().equalsIgnoreCase(name)) {  // if race name matches
                    // skip first token then read values
                    size = lineScan.next();
                    speed = lineScan.nextInt();
                }
                lineScan.close();   // Close line scanner
            }
        }
        in.close(); // Close file reader
    }

    /**
     * Applies this race's racial modifications to the parameter character
     * @param character Reference to the character that will be modified
     */
    public void applyRacialModifiers(Character character) {
        // No modifiers for this base class
    }

    /**
     * Returns the name of the race
     * @return String The name of the race
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the race's speed in feet
     * @return int The creature's speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Returns the race's size
     * @return String The creature's size e.g. "Medium"
     */
    public String getSize() {
        return size;
    }
}
