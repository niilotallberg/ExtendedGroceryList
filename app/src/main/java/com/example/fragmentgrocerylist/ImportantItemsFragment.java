package com.example.fragmentgrocerylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentgrocerylist.R;
import com.example.fragmentgrocerylist.ShoppingItem;
import com.example.fragmentgrocerylist.ShoppingListAdapter;

import java.util.ArrayList;

public class ImportantItemsFragment extends Fragment {
    private ArrayList<ShoppingItem> shoppingItems;
    private ArrayList<ShoppingItem> importantItems;
    private RecyclerView recyclerView;
    private ShoppingListAdapter adapter;

    public ImportantItemsFragment(ArrayList<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
        this.importantItems = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_important_items, container, false);
        recyclerView = view.findViewById(R.id.important_items_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateImportantItems();
        adapter = new ShoppingListAdapter(importantItems);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void updateImportantItems() {
        importantItems.clear();
        for (ShoppingItem item : shoppingItems) {
            if (item.isImportant()) {
                importantItems.add(item);
            }
        }
    }
}