package com.example.cs213_project_5;

import java.util.ArrayList;

/**
 * Extend Pizza Class and Define Seafood Class
 * @author Kenrick Eagar, Zachary Derish
 */
public class Seafood extends Pizza{

    public static final double PRICE = 17.99;
    private final String type = "Seafood";

    /**
     * Deluxe default constructor
     */
    public Seafood(){
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEATS);
        this.toppings = toppings;
        this.sauce = Sauce.ALFREDO;
        this.size = Size.SMALL;
    }
    /**
     * Method to return Price of Seafood Pizza
     * @return double, representing price of pizza
     */
    @Override
    public double price(){
        double finalPrice = PRICE;
        if(this.size == Size.MEDIUM){
            finalPrice += 2;
        }
        if(this.size == Size.LARGE){
            finalPrice += 4;
        }
        if(this.extraCheese){
            finalPrice += 1;
        }
        if(this.extraSauce){
            finalPrice += 1;
        }
        return finalPrice;
    }

    /**
     * Type getter method.
     * @return String
     */
    public String getType() {
        return this.type;
    }

    /**
     * Seafood Pizza String format.
     * @return String
     */
    @Override
    public String toString() {
        return "[" + type + "] " + super.toString();
    }
}
