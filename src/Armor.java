/**
 * Armor extends the item class to model armor pieces.
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */
public class Armor extends Item {

    private int armorClass;
    private int strengthRequirement = 0;
    private boolean stealthDisadvantage = false;

    public Armor(String name, int cost, double weight, int armorClass, int strengthRequirement,
                 boolean stealthDisadvantage) {
        super(name, cost, weight);  // Call super constructor

        // Assign attribute values
        this.armorClass = armorClass;
        this.strengthRequirement = strengthRequirement;
        this.stealthDisadvantage = stealthDisadvantage;
    }
}
