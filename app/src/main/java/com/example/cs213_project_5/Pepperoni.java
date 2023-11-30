package com.example.cs213_project_5;

import java.util.ArrayList;


/**
 * Extend Pizza Class and Define Pepperoni Class
 * @author Kenrick Eagar, Zachary Derish
 */
public class Pepperoni extends Pizza{

    public static final double PRICE = 10.99;
    private final String type = "Pepperoni";
    public Pepperoni(){
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.PEPPERONI);
        this.toppings = toppings;
        this.sauce = Sauce.TOMATO;
        this.size = Size.SMALL;
    }
    /**
     * Method to return Price of Pepperoni Pizza
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
     * Pepperoni Pizza String format.
     * @return String
     */
    @Override
    public String toString() {
        return "[" + type + "] " + super.toString();
    }
}
