package com.example.cs213_project_5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Define StoreOrder class.
 * @author Kenrick Eagar, Zachary Derish
 */

public class StoreOrders {

    private static StoreOrders storeOrders;
    private ArrayList<Order> storeOrdersList; //this will be the only instance variable used for construction
    private ArrayList<Order> storeOrdersPlaced;

    private static int orderNumber = 0; //static variable as requested in instructions

    /**
     * Store order object default constructor.
     * Singleton Design.
     */
    private StoreOrders(){
        this.storeOrdersList = new ArrayList<>();
        this.storeOrdersPlaced = new ArrayList<>();
        // create first order
        ArrayList<Pizza> pizzaList = new ArrayList<>();
        Order firstOrder = new Order(0, pizzaList);
        this.storeOrdersList.add(firstOrder);
    }

    /**
     * Store order object constructor
     * @param storeOrders, a list of order objects
     */
    /*public StoreOrders(ArrayList<Order> storeOrders){
        this.storeOrders = storeOrders;
    }*/


    /**
     * Get StoreOrders object.
     * @return StoreOrders
     */
    public static synchronized StoreOrders getStoreOrders() {
        if (storeOrders == null) {
            storeOrders = new StoreOrders();
        }
        return storeOrders;
    }

    /**
     * Getter method for Order ArrayList.
     * @return ArrayList<Order>
     */
    public ArrayList<Order> getStoreOrdersList() {
        return this.storeOrdersList;
    }

    /**
     * Getter method for order placed ArrayList
     * @return Arraylist<Order>
     */
    public ArrayList<Order> getStoreOrdersPlaced() {
        return this.storeOrdersPlaced;
    }

    /**
     * Get the next available order number
     * @return integer of the current order number that is available.
     */
    public int getAvailable_OrderNumber() {
        int returnNum = orderNumber;
        return returnNum;
    }

    /**
     * Search for index of given order
     * @param order, the order we want to search for
     * @return index of order in list, -1 if object is not in list
     */
    public int findIndexOfOrder(Order order){
        for(int i =0; i<this.storeOrdersList.size(); i++){
            if(storeOrdersList.get(i).getOrderNumber() == order.getOrderNumber()){
                return i;
            }
        }
        return -1; //NOT FOUND
    }

    /**
     * Add order object to store orders order list
     * @param order, the order we want to add
     */
    public void addOrder(Order order) {
        int index = findIndexOfOrder(order);
        this.storeOrdersList.set(index, order);
        this.storeOrdersPlaced.add(index, order);
      //  this.storeOrders.set(getAvailable_OrderNumber(), order);


        orderNumber++;

        ArrayList<Pizza> pizzaList = new ArrayList<>();
        Order setOrder = new Order(orderNumber, pizzaList);
        this.storeOrdersList.add(setOrder);
    }

    /**
     * Get list of order numbers
     * @return list of order numbers
     */
    public ArrayList<Integer> getOrderNumbers(){
        ArrayList<Integer> orderNums = new ArrayList<>();
        for(int i = 0; i<this.storeOrdersList.size(); i++){
            int tempNum = this.storeOrdersList.get(i).getOrderNumber();
            orderNums.add(tempNum);
        }
        return orderNums;
    }

    /**
     * Return a given order object based off the order number
     * @param orderNumber, the order number of order object we want
     * @return order object
     */
    public Order find(int orderNumber){
        for(int i =0; i<this.storeOrdersList.size(); i++){
            if(this.storeOrdersList.get(i).getOrderNumber() == orderNumber){
                return storeOrdersList.get(i);
            }
        }
        return storeOrdersList.get(0);
    }

    /**
     * Remove order based off given order number
     * @param orderNumber, the order/order number we want to remove
     * @return true if removed, false otherwise
     */
    public boolean removeOrder(int orderNumber){
        Order removeMe = find(orderNumber);
        this.storeOrdersList.remove(removeMe);
        return true;
    }

    /**
     * Get size of orders list
     * @return store orders array list size
     */
    public int numberOfOrders(){
        return this.storeOrdersList.size();
    }

    /**
     * Creates string representation of order for store orders export method
     * @param index, index/order number
     * @return string representation of order
     */
    public String orderToString(int index){
       Order order = storeOrdersList.get(index);
       int orderNumber = order.getOrderNumber();
       double total = order.getOrder_Subtotal();
       double tax = 0.06625;
       total = (total*tax) + total;

       String returnString = "Order Number " + Integer.toString(orderNumber);
       ArrayList<String> pizzaStrings = order.getPizzas();
       if(pizzaStrings.isEmpty()){
           return "";
       }
       for(int i =0; i<pizzaStrings.size(); i++){
           returnString += "\n" + pizzaStrings.get(i);
       }
       String totalString = new DecimalFormat("#,##0.00").format(total);
       returnString+= "\n" + "Total Price: $"+ totalString;
       return returnString;
    }

}
