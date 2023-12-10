package com.example.cs213_project_5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/**
 * Define ItemsAdapter class and extend the RecyclerView Class.
 * @author Kenrick Eagar, Zachary Derish
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsHolder>{
    private Context context; //need the context to inflate the layout
    private ArrayList<Item> items; //need the data binding to each row of RecyclerView

    /**
     * Items Adaptor Constructor
     * @param context, current context
     * @param items, current items
     */
    public ItemsAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    /**
     * This method will inflate the row layout for the items in the RecyclerView
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the row layout for the items
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_view, parent, false);

        return new ItemsHolder(view);
    }

    /**
     * Assign data values for each row according to their "position" (index) when the item becomes
     * visible on the screen.
     * @param holder the instance of ItemsHolder
     * @param position the index of the item in the list of items
     */
    @Override
    public void onBindViewHolder(@NonNull ItemsHolder holder, int position) {
        //assign values for each row
        holder.pizzaName.setText(items.get(position).getPizzaName());
        holder.toppings.setText(items.get(position).getToppings());
        holder.sauce.setText(items.get(position).getSauce());
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    /**
     * Get the number of items in the ArrayList.
     * @return the number of items in the list.
     */
    @Override
    public int getItemCount() {
        return items.size(); //number of MenuItem in the array list.
    }

    /**
     * Get the views from the row layout file, similar to the onCreate() method.
     */
    public class ItemsHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView pizzaName, toppings, sauce;
        private RelativeLayout parentLayout; //this is the row layout

        public ItemsHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            pizzaName = itemView.findViewById(R.id.pizzaName);
            toppings = itemView.findViewById(R.id.toppings);
            sauce = itemView.findViewById(R.id.sauce);
            parentLayout = itemView.findViewById(R.id.rowView);
            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), ItemSelectedActivity.class);
                    int position = getAdapterPosition();
                    intent.putExtra("Sauce", items.get(position).getSauce());
                    intent.putExtra("PizzaName", items.get(position).getPizzaName());
                    intent.putExtra("Toppings", items.get(position).getToppings());
                    intent.putExtra("Image", items.get(position).getImage());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

}
