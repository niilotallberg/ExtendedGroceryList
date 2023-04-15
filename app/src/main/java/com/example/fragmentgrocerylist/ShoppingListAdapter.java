package com.example.fragmentgrocerylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {
    private ArrayList<ShoppingItem> shoppingItems;

    public ShoppingListAdapter(ArrayList<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item_layout, parent, false);
        return new ShoppingListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListViewHolder holder, int position) {
        ShoppingItem currentItem = shoppingItems.get(position);
        holder.itemName.setText(currentItem.getItemName());
        holder.extraInfo.setText(currentItem.getExtraInfo());
    }

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }

    public static class ShoppingListViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public TextView extraInfo;

        public ShoppingListViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            extraInfo = itemView.findViewById(R.id.extra_info);
        }
    }
}