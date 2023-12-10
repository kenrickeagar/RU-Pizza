package com.example.cs213_project_5;

import static com.example.cs213_project_5.PizzaMaker.createPizza;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Define Specialty Pizza Activity class.
 * @author Kenrick Eagar, Zachary Derish
 */

public class SpecialtyPizzaActivity extends AppCompatActivity {

    /**
     * Method to create and initialize features
     * @param savedInstanceState, the current instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty_pizza);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<Item> items = new ArrayList<>();
        Deluxe deluxe = new Deluxe();
        items.add(new Item(deluxe.getType(), R.drawable.deluxe, deluxe.toppings.toString(), deluxe.sauce.toString()));
        Meatzza meatzza = new Meatzza();
        items.add(new Item(meatzza.getType(), R.drawable.meatzza, meatzza.toppings.toString(), meatzza.sauce.toString()));
        Pepperoni pepperoni = new Pepperoni();
        items.add(new Item(pepperoni.getType(), R.drawable.pepperoni, pepperoni.toppings.toString(), pepperoni.sauce.toString()));
        Seafood seafood = new Seafood();
        items.add(new Item(seafood.getType(), R.drawable.seafood, seafood.toppings.toString(), seafood.sauce.toString()));
        Supreme supreme = new Supreme();
        items.add(new Item(supreme.getType(), R.drawable.supreme, supreme.toppings.toString(), supreme.sauce.toString()));
        Hawaiian hawaiian = new Hawaiian();
        items.add(new Item(hawaiian.getType(), R.drawable.hawaiian, hawaiian.toppings.toString(), hawaiian.sauce.toString()));
       BBQChicken bbqChicken = new BBQChicken();
        items.add(new Item(bbqChicken.getType(), R.drawable.bbqchicken, bbqChicken.toppings.toString(), bbqChicken.sauce.toString()));
        Breakfast breakfast = new Breakfast();
        items.add(new Item(breakfast.getType(), R.drawable.breakfast, breakfast.toppings.toString(), breakfast.sauce.toString()));
        Hamburger hamburger = new Hamburger();
        items.add(new Item(hamburger.getType(), R.drawable.hamburger, hamburger.toppings.toString(), hamburger.sauce.toString()));
        BuffaloChicken buffaloChicken = new BuffaloChicken();
        items.add(new Item(buffaloChicken.getType(), R.drawable.buffalochicken, buffaloChicken.toppings.toString(), buffaloChicken.sauce.toString()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new ItemsAdapter(getApplicationContext(), items));
        recyclerView.setAdapter(new ItemsAdapter(this, items));
    }
}