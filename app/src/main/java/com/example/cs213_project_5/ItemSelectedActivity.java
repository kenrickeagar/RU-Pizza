package com.example.cs213_project_5;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ItemSelectedActivity extends AppCompatActivity {

    private TextView pizzaName, sauce, toppings;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_selected);
        pizzaName = findViewById(R.id.pizzaNameSelected);
        toppings = findViewById(R.id.toppingsSelected);
        sauce = findViewById(R.id.sauceSelected);
        image = findViewById(R.id.imageViewSelected);
        Intent intent = getIntent();
        pizzaName.setText(intent.getStringExtra("PizzaName"));
        toppings.setText(intent.getStringExtra("Toppings"));
        sauce.setText(intent.getStringExtra("Sauce"));
        image.setImageResource(intent.getIntExtra("Image", 0));

    }
}