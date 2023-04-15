package com.example.fragmentgrocerylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AddItemFragment extends Fragment {
    private EditText itemNameInput;
    private EditText extraInfoInput;
    private CheckBox isImportantCheckbox;
    private Button addItemButton;
    private ArrayList<ShoppingItem> shoppingItems;

    public AddItemFragment(ArrayList<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);
        itemNameInput = view.findViewById(R.id.item_name_input);
        extraInfoInput = view.findViewById(R.id.extra_info_input);
        isImportantCheckbox = view.findViewById(R.id.is_important_checkbox);
        addItemButton = view.findViewById(R.id.add_item_button);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = itemNameInput.getText().toString();
                String extraInfo = extraInfoInput.getText().toString();
                boolean isImportant = isImportantCheckbox.isChecked();
                shoppingItems.add(new ShoppingItem(itemName, extraInfo, isImportant));
                itemNameInput.setText("");
                extraInfoInput.setText("");
                isImportantCheckbox.setChecked(false);
            }
        });

        return view;
    }
}