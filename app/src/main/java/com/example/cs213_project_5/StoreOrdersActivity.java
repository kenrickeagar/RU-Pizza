package com.example.cs213_project_5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Define Store Order Activity class.
 * @author Kenrick Eagar, Zachary Derish
 */

public class StoreOrdersActivity extends AppCompatActivity {

    private Spinner orderNumSpinner;
    private ListView pizzaOrderList;
    private Button cancelButton;
    private TextView totalText;
    private int orderSelected = -1; //Default


    /**
     * Method to fill spinner with order numbers
     */
    private void fillOrderNumSpinner(){
        StoreOrders storeOrder = StoreOrders.getStoreOrders();
        ArrayList<Integer> orderNums = storeOrder.getOrderNumbersPlaced() ;
        ArrayAdapter<Integer> orderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,orderNums);
        orderAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        orderNumSpinner.setAdapter(orderAdapter);
    }
    /**
     * Method to format Double to a String
     * @param price, the double we want to format
     * @return a string representing price
     */
    private String formatDouble(Double price) {
        DecimalFormat format = new DecimalFormat("#.##");
        price = Double.parseDouble(format.format(price));
        return String.valueOf(price);
    }

    /**
     * Method to populate listview with orders
     */

    private void populateListView(){
        StoreOrders storeOrder = StoreOrders.getStoreOrders();
        Order selectedOrder = storeOrder.find(orderSelected);
        ArrayList<String> pizzas = selectedOrder.getPizzas();
        ArrayAdapter<String> orderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,pizzas);
        orderAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        pizzaOrderList.setAdapter(orderAdapter);

        Double total = selectedOrder.getOrder_total();
        totalText.setText(formatDouble(total));

    }



    /**
     * Method to cancel order when cancel buttons clicked
     * @param view, the current view
     */
    public void onSoCancelButton(View view){
        StoreOrders storeOrder = StoreOrders.getStoreOrders();
        if(!storeOrder.hasOrders()){
            Toast.makeText(this, "No Orders Placed", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean removeMe = storeOrder.removeOrder(orderSelected);
        pizzaOrderList.setAdapter(null);
        fillOrderNumSpinner();
        totalText.setText("");
        Toast.makeText(this, "Order: " + orderSelected + " Cancelled!", Toast.LENGTH_SHORT).show();
    }


    /**
     * Method to create and initialize features
     * @param savedInstanceState, the current instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        orderNumSpinner = findViewById(R.id.soOrder_spinner);
        cancelButton = findViewById(R.id.soCancel_Button);
        pizzaOrderList = findViewById(R.id.soListView);
        totalText = findViewById(R.id.soTotalText);
        fillOrderNumSpinner();
        orderNumSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                orderSelected = i;
                populateListView();

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


}