package com.example.cs213_project_5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class BuildYourOwnActivity extends AppCompatActivity {

    TextView listToppings;
    boolean[] selectedToppings;
    ArrayList<Integer> topArray = new ArrayList<>();

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_your_own);
        listToppings = findViewById(R.id.list_topps);

        selectedToppings = new boolean[toppings.length];
        listToppings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                //can add a clear all option here
                builder.show();
            }
        });








    } //end of create bracket


}