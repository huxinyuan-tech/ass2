package com.unsw.infs3634.borgerkong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewOrderListener();
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(new MenuAdapter(prepareMenuItems(), DataCentre.getMyOrders()));
    }

    private void setViewOrderListener() {
        findViewById(R.id.viewOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MyOrderActivity.class);
                startActivity(i);
            }
        });
    }

    private List<MenuItem> prepareMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Burger", 5.0, R.drawable.burger, "Beef burger is popular"));
        menuItems.add(new MenuItem("Nuggets", 3.5, R.drawable.nuggets, "Chicken nuggets are welcome by children"));
        menuItems.add(new MenuItem("Fries", 4.0, R.drawable.fries, "Fries is perfect with tomato sauce"));
        menuItems.add(new MenuItem("Chicken Wings", 6.0, R.drawable.wings, "Deep fried wings yummy"));
        menuItems.add(new MenuItem("Ice Cream", 2.0, R.drawable.icecream, "Good to have as desert"));
        menuItems.add(new MenuItem("Salad", 7.5, R.drawable.salad, "This is a very healthy option"));
        menuItems.add(new MenuItem("Steak", 10.5, R.drawable.steak, "Good to have after gym"));
        menuItems.add(new MenuItem("Noodle", 11.5, R.drawable.noodle, "Good to have for lunch"));
        menuItems.add(new MenuItem("Fries Rice", 9.5, R.drawable.rice, "Very tasty fries rice"));
        menuItems.add(new MenuItem("dumplings", 7.5, R.drawable.dump, "Fantastic dumplings for you"));
        menuItems.add(new MenuItem("Shrimps", 17.5, R.drawable.shrimp, "Deep fries shrimps which activate your appetite"));
        menuItems.add(new MenuItem("Crispy Pork", 7.5, R.drawable.pork, "Beautiful crispy pork"));
        menuItems.add(new MenuItem("Ribs", 13.5, R.drawable.ribs, "The right ribs for you"));
        menuItems.add(new MenuItem("Watermelon", 5.5, R.drawable.watermelon, "Watermelon to keep you cool"));
        menuItems.add(new MenuItem("Mango", 2.5, R.drawable.mango, "Golden mango to serve for you"));



        return menuItems;
    }

}
