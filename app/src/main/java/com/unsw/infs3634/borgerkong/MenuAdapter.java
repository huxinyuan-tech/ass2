package com.unsw.infs3634.borgerkong;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter {

    private List<MenuItem> menuItems;
    private List<MyOrder> myOrders;

    public MenuAdapter(List<MenuItem> menuItems, List<MyOrder> myOrders) {
        this.menuItems = menuItems;
        this.myOrders = myOrders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.menu_item_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final MenuItem menuItem = menuItems.get(i);
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.name.setText(menuItem.getName());
        myViewHolder.img.setImageResource(menuItem.getImageResourceId());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MenuItemDetailsActivity.class);
                i.putExtra("menuItem", menuItem);
                i.putExtra("myOrders", (Serializable)myOrders);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView img;

        MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
        }
    }

}
