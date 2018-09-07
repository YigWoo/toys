package com.yigwoo.eaaDev.event.collaboration.command;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StockExchange {
    private List<Order> outstandingOrders = new ArrayList<>();
    private String symbol;

    public void submitOrder(Order order) {
        outstandingOrders.add(order);
    }

    public void executeAll() {
        outstandingOrders.clear();
    }
}
