package com.example.cs213_project_5;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Define abstract Pizza class
 * @author Kenrick Eagar, Zachary Derish
 */
public abstract class Pizza {

    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected boolean extraSauce;
    protected boolean extraCheese;

    /**
     * Method to return and calculate price of pizza
     * @return double representing price of pizza object
     */
    public abstract double price();

    /**
     * Pizza String format.
     * @return String
     */
    @Override
    public String toString() {
        String price = new DecimalFormat("#,##0.00").format(this.price());
        String toppings = this.toppings.toString().replace("[", "");
        toppings = toppings.replace("]", "");

        String extras ="";
        if(extraSauce){
            extras+= ", EXTRA SAUCE";
        }
        if(extraCheese){
            extras += ", EXTRA CHEESE";
        }
        return toppings + extras + " $" + price;
    }

}
