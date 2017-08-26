import java.util.ArrayList;

/**
 * Weapon extends the item class to model weapons.
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */
public class Weapon extends Item {
    private int numberOfDamageDice; // How many damage dice it gets per attack e,g, "2" if it's 2d6
    private int diceType;           // What type of dice it rolls, e.g. "6" if it rolls 2d6
    private String damageType;      // "Slashing", "Piercing", etc.
    private ArrayList<String> properties;   // Special rules like "Finesse" etc.

    /**
     * Constructor for Weapon objects
     * @param name String The name of the weapon
     * @param cost int The cost in copper coins for the item
     * @param weight double The weight of the item in lbs.
     * @param numberOfDamageDice int The number of damage dice the weapon rolls per attack
     * @param diceType int The number of faces on the dice that the weapon rolls to attack
     * @param damageType String The weapon damage type e.g. "Slashing"
     * @param properties Variable number of Strings describing the weapon's additional properties e.g. "Reach"
     */
    public Weapon(String name, int cost, double weight, int numberOfDamageDice, int diceType, String damageType,
                  String... properties) {
        super(name, cost, weight);  // Call super constructor

        // assign attribute values
        this.numberOfDamageDice = numberOfDamageDice;
        this.diceType = diceType;
        this.damageType = damageType;

        // Loop through Strings and add to properties list
        for (String s : properties) {
            this.properties.add(s);
        }
    }
}
