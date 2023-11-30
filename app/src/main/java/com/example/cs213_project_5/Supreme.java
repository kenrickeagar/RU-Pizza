package com.example.cs213_project_5;

import java.util.ArrayList;

/**
 * Extend Pizza Class and Define Supreme Class
 * @author Kenrick Eagar, Zachary Derish
 */
public class Supreme extends Pizza{
    public static final double PRICE = 15.99;
    private final String type = "Supreme";

    /**
     * Default Constructor for Supreme Object
     */
    public Supreme(){
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPERS);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
        this.toppings = toppings;
        this.sauce = Sauce.TOMATO;
    }

    /**
     * Method to return Price of Supreme Pizza
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
     * Supreme Pizza String format.
     * @return String
     */
    @Override
    public String toString() {
        return "[" + type + "] " + super.toString();
    }
}
