package com.unsw.infs3634.borgerkong;

import java.io.Serializable;

public class MyOrder implements Serializable {

    private MenuItem menuItem;
    private int number;

    public MyOrder(MenuItem menuItem, int number) {
        this.menuItem = menuItem;
        this.number = number;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
