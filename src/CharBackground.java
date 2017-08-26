/**
 * CharBackground models a Dungeons and Dragon's 5E background, with appropriate proficiencies etc.
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CharBackground {
    private String name;
    private ArrayList<String> skillProficiencies;
    private ArrayList<String> toolProficiencies;
    private ArrayList<String> languages;
    private HashMap<String, Integer> equipment;
    private int[] money = new int[5];
    private String feature;

    public CharBackground() {

    }

    public HashMap<String, Integer> getEquipment() {
        return equipment;
    }
}
