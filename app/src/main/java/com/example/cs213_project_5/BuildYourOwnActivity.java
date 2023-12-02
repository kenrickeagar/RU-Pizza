package com.example.cs213_project_5;

import static com.example.cs213_project_5.PizzaMaker.createPizza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class BuildYourOwnActivity extends AppCompatActivity {

    TextView listToppings;
    boolean[] selectedToppings;
    ArrayList<Integer> topArray = new ArrayList<>();

    private BuildYourOwn pizza = (BuildYourOwn) createPizza("BuildYourOwn");

    String[] toppings = {"SAUSAGE", "PEPPERONI", "GREEN_PEPPERS", "ONION", "MUSHROOM", "BLACK_OLIVE",
                        "BEEF", "HAM", "SHRIMP","SQUID","CRAB_MEATS","PINEAPPLE","PICKLES","CHICKEN",
                        "FRIED_EGG", "BACON", "SPINACH", "HAMBURGER"};




    private void removeElement(ArrayList<Integer> list, int target){
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == target){
                list.remove(i);
                return;
            }
        }
    }

    private void showToppingsDialogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(BuildYourOwnActivity.this);
        builder.setTitle("Select Toppings");
        builder.setCancelable(false);
        builder.setMultiChoiceItems(toppings, selectedToppings, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b) {
                    topArray.add(i);
                    Collections.sort(topArray);
                } else {
                    removeElement(topArray, i);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override //action once OK is selected
            public void onClick(DialogInterface dialogInterface, int i) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < topArray.size(); j++) {
                    stringBuilder.append(toppings[topArray.get(j)]);
                    if (j != topArray.size() - 1) {
                        stringBuilder.append(", ");
                    }
                }
                listToppings.setText(stringBuilder.toString());
            }
        });
        builder.show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_your_own);
        listToppings = findViewById(R.id.list_topps);

        selectedToppings = new boolean[toppings.length];
        listToppings.setOnClickListener(view ->  {
            showToppingsDialogue();
        });
        Spinner sauceSpinner = findViewById(R.id.sauce_spinner);
        Spinner sizeSpinner = findViewById(R.id.size_spinner);
//getting sauce type
        sauceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sauceType = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(BuildYourOwnActivity.this,sauceType+" Sauce Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sauceSpinner.setSelection(0);
            }
        });
    ArrayList<String> sauceList = new ArrayList<>();
    sauceList.add("Tomato");
    sauceList.add("Alfredo");
    ArrayAdapter<String> sauceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,sauceList);
    sauceAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
    sauceSpinner.setAdapter(sauceAdapter);
//initialize size spinner
    sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String sizeSelected = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(BuildYourOwnActivity.this,"Size Selected "+ sizeSelected,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        sizeSpinner.setSelection(0);
        }
    });

        ArrayList<String> sizeList = new ArrayList<>();
        sizeList.add("Small");
        sizeList.add("Medium");
        sizeList.add("Large");
        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,sizeList);
        sizeAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        sizeSpinner.setAdapter(sizeAdapter);

    } //end of create bracket


}