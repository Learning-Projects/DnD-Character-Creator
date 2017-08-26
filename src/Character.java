/**
 * Character models a Dungeons and Dragon's 5E character.
 * @author Christopher Evans - cevans88@hotmail.co.uk
 * No copyright, free to use and modify
 * created -  23/08/2017
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Character {
    // Block of personal attributes that the character exhibits
    private String name;
    private CharBackground background;
    private int level;
    private int barbLevel = 0;  // Have to track individual class levels in case of multiclassing
    private int bardLevel = 0;
    private int clericLevel = 0;
    private int druidLevel = 0;
    private int fighterLevel = 0;
    private int monkLevel = 0;
    private int paladinLevel = 0;
    private int rangerLevel = 0;;
    private int rogueLevel = 0;
    private int sorcererLevel= 0;
    private int warlockLevel = 0;
    private int wizardLevel = 0;
    private Race race;
    private String alignment;
    private int experience = 0;
    private int age;

    // The RP fluff attributes
    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    // The gritty stats that are used in combat and ability check mechanics
    private int proficiencyBonus;
    private int armourClass;
    private int initiativeMod = 0;
    private ArrayList<String> savingThrowProficiencies;
    private int speed;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int curHitpoints;
    private int maxHitpoints;
    private int remainingHitDice;
    private boolean hasInspiration = false;

    // Pair of Array Lists to store all their skills
    private ArrayList<String> proficienciesAndLanguages;
    private ArrayList<String> featuresAndTraits;

    // Lists to track the money and equipment that they are carrying
    private int[] money = new int[5];   // money stored as an array[copper, silver, electrum, gold, platinum]
    private HashMap<String, Integer> equipment;
    private ArrayList<String> equippedItems;  // the equipment they actually have equipped

    /**
     * Construct a level 1 character with the given values.
     * @param name The character's name
     * @param alignment The character's alignment
     * @param age The character's age
     * @param personality A description of the character's personality traits
     * @param ideals A description of the character's ideals
     * @param bonds A description of what bonds the character
     * @param flaws A description of the character's flaws
     * @param characterClass Specifies what class the character begins at
     * @param useDefaultEquipment Specify whether starting equipment is being customised
     * @param race Specify the character's race
     * @param background Specify the character's background
     */
    public Character(String name, String alignment, int age, String personality, String ideals, String bonds,
                     String flaws, CharClass characterClass, boolean useDefaultEquipment, Race race,
                     CharBackground background) {
        // Set attributes from parameters
        this.name = name;
        this.alignment = alignment;
        this.age = age;
        this.personalityTraits = personality;
        this.ideals = ideals;
        this.bonds = bonds;
        this.flaws = flaws;
        this.race = race;
        this.background = background;

        incrementLevel(characterClass); // Increment the level of the class

        // Check if the character is to be created with default equipment, assign equipment as appropriate
        if (useDefaultEquipment == true) {
            equipment = characterClass.getDefaultEquipment();  // assign default class equipment
            equipment.putAll(background.getEquipment());    // add background equipment to that
        }

        // Apply racial modifiers
        applyRacialModifiers(race);

    }

    /**
     * Accepts a CharClass object and increments the level of the character in that class
     * @param characterClass The class that the character should gain a level in
     */
    public void incrementLevel(CharClass characterClass) {
        // Check the name of the parameter class and increment the appropriate class
        switch (characterClass.getName()) {
            case "Barbarian": barbLevel++;
                break;
            case "Bard": bardLevel++;
                break;
            case "Cleric": clericLevel++;
                break;
            case "Druid": druidLevel++;
                break;
            case "Fighter": fighterLevel++;
                break;
            case "Monk": monkLevel++;
                break;
            case "Paladin": paladinLevel++;
                break;
            case "Ranger": rangerLevel++;
                break;
            case "Rogue": rogueLevel++;
                break;
            case "Sorcerer": sorcererLevel++;
                break;
            case "Warlock": warlockLevel++;
                break;
            case "Wizard": wizardLevel++;
                break;
            default: System.out.println("Error levelling up class.");   // error detection
                break;
        }
    }

    /**
     * Call the appropriate race's method to apply their racial modifiers
     * @param race This character's Race
     */
    public void applyRacialModifiers(Race race) {
        race.applyRacialModifiers(this);    // Call the method to apply the modifiers
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    /**
     * Adds a quantity of items to the character's equipment hashmap
     * @param name String The name of the item
     * @param quantity int The number of that item to be added
     */
    public void addItem(String name, int quantity) {
        /**
         * Check if equipment already contains item, increment if so, otherwise add it in
         */
        if (equipment.containsKey(name)) {  // If equipment already contains item
            equipment.put(name, equipment.get(name) + quantity);    // add the desired quantity to it
        } else {    // Otherwise put it in
            equipment.put(name, quantity);
        }
    }

    /**
     * Deduct a quantity of a specified item from the character's equipment
     * @param name String The item name
     * @param quantity int The quantity of that item to deduct
     * @throws NullPointerException Throws exception if item isn't found or insufficient quantity of it
     */
    public void deductItem(String name, int quantity) throws NullPointerException{
        /**
         * Check if equipment contains sufficient quantity of the item, then decrement or throw exception
         */
        if (containsItem(name) && equipment.get(name) >= quantity) { // Check that equipment has item
            equipment.put(name, equipment.get(name) - quantity);    // Update quantity
        } else {    // otherwise throw exception
            throw new NullPointerException("Equipment does not contain that item, or insufficient quantity.");
        }
    }

    /**
     * Checks if the character has a specified item in their equipment HashMap
     * @param name String The name of the item
     * @return boolean True if that item is found in their equipment, false otherwise
     */
    public boolean containsItem(String name) {
        /**
         * Check if equipment contains item matching that name, return appropriate boolean result
         */
        if (equipment.containsKey(name)) {  // If found, return true
            return true;
        } else {    // otherwise return false
            return false;
        }
    }


}
