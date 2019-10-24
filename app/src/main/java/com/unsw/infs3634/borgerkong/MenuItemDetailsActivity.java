package com.unsw.infs3634.borgerkong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuItemDetailsActivity extends AppCompatActivity {

    private ImageView img;
    private TextView name;
    private TextView price;
    private TextView description;
    private Button minus;
    private Button plus;
    private TextView quantity;
    private Button addOrder;
    private MenuItem menuItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_item_details);
        img = findViewById(R.id.img);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        description = findViewById(R.id.description);
        quantity = findViewById(R.id.quantity);
        addOrder = findViewById(R.id.addOrder);
        setMinusListener();
        setPlusListener();
        setAddOrderListener();
        menuItem = (MenuItem) getIntent().getSerializableExtra("menuItem");
        setData();
    }

    private void setData() {
        img.setImageResource(menuItem.getImageResourceId());
        name.setText(menuItem.getName());
        price.setText("$" + menuItem.getPrice());
        description.setText(menuItem.getDescription());
    }

    private void setMinusListener() {
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curQuantity = getCurrentQuantity();

                if (curQuantity > 0) {
                    quantity.setText(String.valueOf(--curQuantity));
                }
            }
        });
    }

    private void setPlusListener() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curQuantity = getCurrentQuantity();
                quantity.setText(String.valueOf(++curQuantity));
            }
        });
    }

    private void setAddOrderListener() {
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataCentre.getMyOrders().add(new MyOrder(menuItem, getCurrentQuantity()));
                finish();
            }
        });
    }

    private int getCurrentQuantity() {
        return Integer.parseInt(quantity.getText().toString());
    }
}
