/**
 * Dwarf is a subclass of Race that models the Dwarf race in D&D 5E
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */

public class Dwarf extends Race{

    /**
     * Basic constructor for the dwarf race.
     */
    public Dwarf() {
        super("Dwarf");    // Call superclass constructor
    }

    /**
     * Applies this race's racial modifications to the parameter character
     * @param character Reference to the character that will be modified
     */
    public void applyRacialModifiers(Character character) {
        character.setConstitution(character.getConstitution() + 2); // Add 2 to constitution
    }

}
