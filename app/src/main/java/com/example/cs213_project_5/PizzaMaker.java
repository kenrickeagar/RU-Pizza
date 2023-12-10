package com.example.cs213_project_5;

import java.util.ArrayList;


/**
 * Define PizzaMaker Class
 * @author Kenrick Eagar, Zachary Derish
 */
public class PizzaMaker {

    /**
     * Based off given pizza type, create and return specificed pizza object
     * @param pizzaType, string representation of pizzatype
     * @return pizza, pizza object
     */
    public static Pizza createPizza(String pizzaType){ // we dont have to worry about size or extrasauce can manually update the pizzas

        if(pizzaType.equals("Deluxe")){
            return new Deluxe();
        }
        if(pizzaType.equals("Supreme")){
            return new Supreme();
        }
        if(pizzaType.equals("Seafood")){
            return new Seafood();
        }
        if(pizzaType.equals("Pepperoni")){
            return new Pepperoni();
        }
        if(pizzaType.equals("Meatzza")){
            return new Meatzza();
        }
        if(pizzaType.equals("BBQ Chicken")){
            return new BBQChicken();
        }
        if(pizzaType.equals("Breakfast")){
            return new Breakfast();
        }
        if(pizzaType.equals("Buffalo Chicken")){
            return new BuffaloChicken();
        }
        if(pizzaType.equals("Hamburger")){
            return new Hamburger();
        }
        if(pizzaType.equals("Hawaiian")){
            return new Hawaiian();
        }

        return new BuildYourOwn();

    }


}
