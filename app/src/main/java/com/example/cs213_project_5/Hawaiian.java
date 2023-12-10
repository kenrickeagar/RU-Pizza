package com.example.cs213_project_5;

import java.util.ArrayList;
/**
 * Extend Pizza Class and Define Hawaiian Class
 * @author Kenrick Eagar, Zachary Derish
 */
public class Hawaiian extends Pizza {

    public static final double PRICE = 11.99;
    private final String type = "Hawaiian";

    /**
     * Hawaiian default constructor
     */
    public Hawaiian(){
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.PINEAPPLE);
        toppings.add(Topping.HAM);
        this.toppings = toppings;
        this.sauce = Sauce.TOMATO;
        this.size = Size.SMALL; //default is small
    }

    /**
     * Method to return Price of Deluxe Pizza
     * @return double, representing price of pizza
     */
    @Override
    public double price(){
        double finalPrice = PRICE;
        if(this.size == Size.MEDIUM){
            finalPrice += 2.0;
        }
        if(this.size == Size.LARGE){
            finalPrice += 4.0;
        }
        if(this.extraCheese){
            finalPrice += 1.0;
        }
        if(this.extraSauce){
            finalPrice += 1.0;
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
     * Deluxe pizza String format.
     * @return String
     */
    @Override
    public String toString() {
        return "[" + type + "] " + super.toString();
    }
}
