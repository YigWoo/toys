package com.yichao.woo.eaaDev.event.collaboration.command;

import java.util.ArrayList;
import java.util.List;

public class Trader {

    public void placeOrder(String symbol, int volume) {
        StockExchange exchange = ServiceLocator.stockExchangeFor(symbol);
        Order order = new Order(symbol, volume, this);
        exchange.submitOrder(order);
    }

    public void clearOrders() {

    }

    public List<Order> outstandingOrders() {
        List<Order> result = new ArrayList<>();
        ServiceLocator.stockExchanges().forEach(stockExchange -> {
            result.addAll(stockExchange.getOutstandingOrders());
        });
        return result;
    }
}

