package com.example.cs213_project_5;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Define Order class.
 * @author Kenrick Eagar, Zachary Derish
 */

public class Order {

    private int orderNumber;
    private ArrayList<Pizza> pizzaList;

    /**
     * Constructor for order object
     * @param orderNumber, integer representing order number
     * @param pizzaList, list of pizza objects
     */
    public Order(int orderNumber, ArrayList<Pizza> pizzaList){
        this.orderNumber = orderNumber;
        this.pizzaList = pizzaList;
    }

    /**
     * Add pizza to pizzaList
     * @param Pizza, the pizza object we want to add to order
     */
    public void addPizza(Pizza pizza){
        this.pizzaList.add(pizza);
    }

    /**
     * Remove pizza at a specified index
     * @param index, find and remove pizza based off index
     */
    public void removePizza(int index){
        this.pizzaList.remove(index);
    }

    /**
     * return order number of order object
     * @return integer representing order number
     */
    public int getOrderNumber(){
        return this.orderNumber;
    }

    /**
     * Get list of Pizza Strings for order.
     * @return ArrayList<String>
     */
    public ArrayList<String> getPizzas() {
        ArrayList<String> pizzas = new ArrayList<>();
        for (int i = 0; i < this.pizzaList.size(); i++) {
            pizzas.add(this.pizzaList.get(i).toString());
        }
        return pizzas;
    }

    /**
     * Get the subtotal for order
     * @return double
     */
    public double getOrder_Subtotal() {
        double returnVal = 0.0;
        for (int i = 0; i < this.pizzaList.size(); i++) {
            returnVal += this.pizzaList.get(i).price();
        }
        return returnVal;
    }
    /**
     * Get the total with tax for order
     * @return double
     */
    public double getOrder_total() {
        double subtotal = getOrder_Subtotal();
        double tax = subtotal * 0.06625;
        return subtotal + tax;
    }

    /**
     * Get Pizza at specified index
     * @param index, the index of the pizza we want to get
     * @return, return pizza object at specified index
     */
    public Pizza getPizza(int index){
        return pizzaList.get(index);
    }

}
