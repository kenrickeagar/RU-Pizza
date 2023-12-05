package com.example.cs213_project_5;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity{

    private TextView orderHeader;
    private Spinner orderSpinner;
    private Button addOrderBtn;
    private ArrayAdapter<String> adapter;
    private ListView currentOrderListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        updatePizzaListView(StoreOrders.getStoreOrders().getAvailable_OrderNumber());
        setOrderNumber();
    }

    public void addOrderBtnClick(View view) {
        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> storeOrdersList = storeOrders.getStoreOrdersList();
        Order currentOrder = storeOrdersList.get(storeOrders.getAvailable_OrderNumber());
        storeOrders.addOrder(currentOrder);

        updatePizzaListView(storeOrders.getAvailable_OrderNumber());
        setOrderNumber();
    }

    private void updatePizzaListView(int orderIndex) {
        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> orders = storeOrders.getStoreOrdersList();
        ArrayList<String> pizzas = orders.get(orderIndex).getPizzas();
        currentOrderListView = findViewById(R.id.currentOrderListView);
        adapter = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pizzas);
        currentOrderListView.setAdapter(adapter);

    }

    private void setOrderNumber() {
        orderHeader = findViewById(R.id.orderHeader);
        int orderNumber = StoreOrders.getStoreOrders().getAvailable_OrderNumber();
        String orderNum = "Current Order Number: " + String.valueOf(orderNumber);
        orderHeader.setText(orderNum);
    }



}