package com.example.cs213_project_5;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemSelectedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView pizzaName, sauce, toppings, price;
    private ImageView image;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private CheckBox cheeseCheckBox, sauceCheckBox;
    private Button specialtyAddOrderBtn;
    private Pizza pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_selected);
        pizzaName = findViewById(R.id.pizzaNameSelected);;
        toppings = findViewById(R.id.toppingsSelected);
        sauce = findViewById(R.id.sauceSelected);
        image = findViewById(R.id.imageViewSelected);
        Intent intent = getIntent();
        pizzaName.setText(intent.getStringExtra("PizzaName"));
        toppings.setText(intent.getStringExtra("Toppings"));
        sauce.setText(intent.getStringExtra("Sauce"));
        image.setImageResource(intent.getIntExtra("Image", 0));

        // Set size spinner
        spinner = findViewById(R.id.specialtySize);
        String[] size = {"Small", "Medium", "Large"}; //could be a list from the backend
        adapter = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, size);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); //add the listener

        String pizzaType = intent.getStringExtra("PizzaName");
        pizza = PizzaMaker.createPizza(pizzaType);
        CharSequence priceSeq = getPrice();
        price.setText(priceSeq);
    }

    private String formatDouble(Double price) {
        DecimalFormat format = new DecimalFormat("#.##");
        price = Double.parseDouble(format.format(price));
        return String.valueOf(price);
    }

    private String getPrice() {
        price = findViewById(R.id.price);
        cheeseCheckBox = findViewById(R.id.cheeseCheckBox);
        sauceCheckBox = findViewById(R.id.sauceCheckBox);

        Double price = pizza.price();
        String priceString = formatDouble(price);

        return "Price: $" + priceString;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String size = spinner.getSelectedItem().toString(); //get the selected item
        Toast.makeText(this, size, Toast.LENGTH_SHORT).show(); //do something about the selected item

        if (size.equals("Small")) {
            pizza.size = Size.SMALL;
        }
        else if (size.equals("Medium")) {
            pizza.size = Size.MEDIUM;
        }
        else {
            pizza.size = Size.LARGE;
        }

        price.setText(getPrice());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //it's fine to leave it blank
    }

    public void extraSauceClick(View view) {
        if (sauceCheckBox.isChecked()) {
            pizza.extraSauce = true;
        }
        else {
            pizza.extraSauce = false;
        }

        price.setText(getPrice());
    }

    public void extraCheeseClick(View view) {
        if (cheeseCheckBox.isChecked()) {
            pizza.extraCheese = true;
        }
        else {
            pizza.extraCheese = false;
        }

        price.setText(getPrice());
    }

    public void specialtyAddOrderClick(View view) {
        // Add order message
        String msg = "Pizza Added to Order!";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show(); //do something about the selected item

        // Add pizza to current order
        StoreOrders storeOrders = StoreOrders.getStoreOrders();
        ArrayList<Order> orders = storeOrders.getStoreOrdersList();
        int orderNumber = storeOrders.getAvailable_OrderNumber();
        Order currentOrder = orders.get(orderNumber);
        currentOrder.addPizza(pizza);

        // Reset button selections
        spinner.setSelection(0);
        cheeseCheckBox.setChecked(false);
        sauceCheckBox.setChecked(false);

        // Reset pizza object
        Intent intent = getIntent();
        String pizzaType = intent.getStringExtra("PizzaName");
        pizza = PizzaMaker.createPizza(pizzaType);
        CharSequence priceSeq = getPrice();
        price.setText(priceSeq);

    }
}