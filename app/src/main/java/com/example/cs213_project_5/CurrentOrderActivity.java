package com.example.cs213_project_5;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity {

    TextView currentOrderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);

        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> orders = storeOrders.getStoreOrdersList();
        int orderNumber = storeOrders.getAvailable_OrderNumber();
        CharSequence order = storeOrders.orderToString(orderNumber);
        currentOrderTextView = findViewById(R.id.currentOrderTextView);
        currentOrderTextView.setText(order);
    }
}