/**
 * Item models a broad variety of items in D&D 5E.
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */
public class Item {
    private String name;
    private int cost;   // cost in coppers
    private double weight; // Weight in lb.

    /**
     * Basic constructor for the Item class
     * @param name String The name of the item
     * @param cost Int The item's cost in copper coins
     * @param weight Double The item's weight in lbs.
     */
    public Item(String name, int cost, double weight) {
        // Assign attribute values from parameters
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }
}
