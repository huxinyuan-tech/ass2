package com.unsw.infs3634.borgerkong;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyOrderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_order);
        recyclerView = findViewById(R.id.recyclerView);
        summary = findViewById(R.id.summary);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(new OrderAdapter(DataCentre.getMyOrders()));
        summary.setText("Total: $" + caculatePrice(DataCentre.getMyOrders()));
    }

    private double caculatePrice(List<MyOrder> myOrders) {
        double total = 0;

        for (MyOrder myOrder: myOrders) {
            total += myOrder.getMenuItem().getPrice() * myOrder.getNumber();
        }

        return total;
    }

}
