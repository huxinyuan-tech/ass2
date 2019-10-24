package com.unsw.infs3634.borgerkong;

import java.io.Serializable;

public class MenuItem implements Serializable {

    private String name;
    private double price;
    private int imageResourceId;
    private String description;

    public MenuItem(String name, double price, int imageResourceId, String description) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }
}
