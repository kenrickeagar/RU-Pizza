package com.example.cs213_project_5;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/**
 * Define the Main Activity class.
 * @author Kenrick Eagar, Zachary Derish
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Method to create and initialize features
     * @param savedInstanceState, the current instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Switch to specialty pizza activity button handler.
     * @param view, the current view
     */
    public void specialtyBtn(View view) {
        Intent intent = new Intent(this, SpecialtyPizzaActivity.class);
        startActivity(intent);
    }

    /**
     * Switch to build your own activity button handler.
     * @param view, the current view
     */
    public void byoBtn(View view) {
        Intent intent = new Intent(this, BuildYourOwnActivity.class);
        startActivity(intent);
    }

    /**
     * Switch to store orders activity button handler.
     * @param view, the current view
     */
    public void storeOrdersBtn(View view) {
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        startActivity(intent);
    }

    /**
     * Switch to current order activity button handler.
     * @param view, the curren view
     */
    public void currentOrderBtn(View view) {
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        startActivity(intent);
    }
}