package com.unsw.infs3634.borgerkong;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderAdapter extends RecyclerView.Adapter {

    private List<MyOrder> myOrders;

    public OrderAdapter(List<MyOrder> myOrders) {
        this.myOrders = myOrders;
    }

    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_order_row, viewGroup, false);
        return new OrderAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyOrder myOrder = myOrders.get(i);
        OrderAdapter.MyViewHolder myViewHolder = (OrderAdapter.MyViewHolder) viewHolder;
        myViewHolder.name.setText(myOrder.getMenuItem().getName() + " x " + myOrder.getNumber());
        myViewHolder.img.setImageResource(myOrder.getMenuItem().getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return myOrders.size();
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
