/**
 * CharClass models a Dungeons and Dragon's 5E character class, with associated abilities etc.
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CharClass {
    private String className;
    private ArrayList<String> savingThrowProficiencies;
    private int hitDieValue;
    private HashMap<String, Integer> defaultEquipment;

    public CharClass(String name, int hitDieValue) {

    }

    public String getName(){
        return className;
    }

    public HashMap<String, Integer> getDefaultEquipment() {
        return defaultEquipment;
    }
}
