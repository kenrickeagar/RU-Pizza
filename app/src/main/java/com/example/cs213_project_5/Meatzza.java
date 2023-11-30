package com.example.cs213_project_5;

import java.util.ArrayList;

/**
 * Extend Pizza class and Define Meatzza Class.
 * @author Kenrick Eagar, Zachary Derish
 */

public class Meatzza extends Pizza{

    public static final double PRICE = 16.99;
    private final String type = "Meatzza";

    /**
     * Meatzza default constructor
     */
    public Meatzza(){
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.HAM);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.PEPPERONI);
        this.toppings = toppings;
        this.sauce = Sauce.TOMATO;
        this.size = Size.SMALL;
    }
    /**
     * Method to return Price of Meatzza Pizza
     * @return double, representing price of pizza
     */
    @Override
    public double price(){
        double finalPrice = PRICE;
        if(this.size == Size.MEDIUM){
            finalPrice+= 2;
        }
        if(this.size == Size.LARGE){
            finalPrice+=4;
        }
        if(this.extraCheese){
            finalPrice+=1;
        }
        if(this.extraSauce){
            finalPrice+=1;
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
     * Meatzza pizza String format.
     * @return String
     */
    @Override
    public String toString() {
        return "[" + type + "] " + super.toString();
    }
}
