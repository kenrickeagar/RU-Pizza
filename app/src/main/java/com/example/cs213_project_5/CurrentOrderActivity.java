package com.example.cs213_project_5;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private TextView orderHeader, subtotalTextView, taxTextView, totalTextView;
    private Spinner orderSpinner;
    private Button addOrderBtn;
    private ArrayAdapter<String> adapter;
    private ListView currentOrderListView;
    ArrayList<String> pizzas;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        updatePizzaListView(StoreOrders.getStoreOrders().getAvailable_OrderNumber());
        setOrderNumber();

        subtotalTextView = findViewById(R.id.subtotal);
        taxTextView = findViewById(R.id.tax);
        totalTextView = findViewById(R.id.total);
        updateTotal();
    }

    public void addOrderBtnClick(View view) {
        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> storeOrdersList = storeOrders.getStoreOrdersList();
        Order currentOrder = storeOrdersList.get(storeOrders.getAvailable_OrderNumber());

        if (currentOrder.getPizzas().isEmpty()) {
            String size = "No pizza selected!";
            Toast.makeText(this, size, Toast.LENGTH_SHORT).show(); //do something about the selected item
            return;
        }

        storeOrders.addOrder(currentOrder);

        updatePizzaListView(storeOrders.getAvailable_OrderNumber());
        setOrderNumber();
        updateTotal();
        selectedPosition = -1;
    }

    private void updatePizzaListView(int orderIndex) {
        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> orders = storeOrders.getStoreOrdersList();
        pizzas = orders.get(orderIndex).getPizzas();
        currentOrderListView = findViewById(R.id.currentOrderListView);
        adapter = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pizzas);
        currentOrderListView.setAdapter(adapter);
        currentOrderListView.setOnItemClickListener(this);

    }

    private void setOrderNumber() {
        orderHeader = findViewById(R.id.orderHeader);
        int orderNumber = StoreOrders.getStoreOrders().getAvailable_OrderNumber();
        String orderNum = "Current Order Number: " + String.valueOf(orderNumber);
        orderHeader.setText(orderNum);
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> orders = storeOrders.getStoreOrdersList();
        Order order = orders.get(storeOrders.getAvailable_OrderNumber());
        /*int orderIndex = storeOrders.findIndexOfOrder(order);
        order.removePizza(position);
        updatePizzaListView(orderIndex);*/
        System.out.println(position);
        selectedPosition = position;
        String size = order.getPizza(position).toString() + " is selected."; //get the selected item
        Toast.makeText(this, size, Toast.LENGTH_SHORT).show(); //do something about the selected item
    }

    public void onRemoveBtnClick(View view) {;
        if (selectedPosition == -1) {
            String size = "No pizza selected!";
            Toast.makeText(this, size, Toast.LENGTH_SHORT).show(); //do something about the selected item
            return;
        }
        try {
            StoreOrders storeOrders = StoreOrders.getStoreOrders();
            ArrayList<Order> orders = storeOrders.getStoreOrdersList();
            Order order = orders.get(storeOrders.getAvailable_OrderNumber());
            int orderIndex = storeOrders.findIndexOfOrder(order);
            order.removePizza(selectedPosition);
            updatePizzaListView(orderIndex);
        }
        catch(IndexOutOfBoundsException exception) {
            String size = "No pizza selected!";
            Toast.makeText(this, size, Toast.LENGTH_SHORT).show(); //do something about the selected item
        }

        updateTotal();

    }

    private String formatDouble(Double price) {
        DecimalFormat format = new DecimalFormat("#.##");
        price = Double.parseDouble(format.format(price));
        return String.valueOf(price);
    }

    /**
     * Update subtotal, tax and total for current order.
     */
    private void updateTotal() {
        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> orders = storeOrders.getStoreOrdersList();
        Order currentOrder = orders.get(storeOrders.getAvailable_OrderNumber());

        double subtotal = currentOrder.getOrder_Subtotal();
        String subtotalText = "Subtotal: $" + formatDouble(subtotal);
        subtotalTextView.setText(subtotalText);

        double TAX_RATE = .06625;
        double tax = subtotal * TAX_RATE;
        String taxText = "Tax: $" + formatDouble(tax);
        taxTextView.setText(taxText);

        double total = subtotal + tax;
        String totalText = "Total: $ " + formatDouble(total);
        totalTextView.setText(totalText);


    }


}