package com.unsw.infs3634.borgerkong;

import java.util.ArrayList;
import java.util.List;

public class DataCentre {

    private static List<MyOrder> myOrders = new ArrayList<>();

    public static List<MyOrder> getMyOrders() {
        return myOrders;
    }
}
