package com.example.fragmentgrocerylist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ShoppingItem> shoppingItems;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ListFragment listFragment;
    private AddItemFragment addItemFragment;
    private ImportantItemsFragment importantItemsFragment;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shoppingItems = new ArrayList<>();
        listFragment = new ListFragment(shoppingItems);
        addItemFragment = new AddItemFragment(shoppingItems);
        importantItemsFragment = new ImportantItemsFragment(shoppingItems);
        viewPager = findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(listFragment, "Kaikki");
        fragmentAdapter.addFragment(addItemFragment, "Lisää");
        fragmentAdapter.addFragment(importantItemsFragment, "Tärkeät");
        viewPager.setAdapter(fragmentAdapter);
    }
}