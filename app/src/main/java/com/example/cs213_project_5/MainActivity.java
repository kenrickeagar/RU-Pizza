package com.example.cs213_project_5;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Switch to specialty pizza activity button handler.
     * @param view
     */
    public void specialtyBtn(View view) {
        Intent intent = new Intent(this, SpecialtyPizza.class);
        startActivity(intent);
    }

    public void byoBtn(View view) {
        Intent intent = new Intent(this, BuildYourOwn.class);
        startActivity(intent);
    }

    public void storeOrdersBtn(View view) {
        Intent intent = new Intent(this, StoreOrders.class);
        startActivity(intent);
    }

    public void currentOrderBtn(View view) {
        Intent intent = new Intent(this, CurrentOrder.class);
        startActivity(intent);
    }
}