package com.yigwoo.eaaDev.event.collaboration.message;

import com.yichao.woo.eaaDev.event.collaboration.command.Order;
import com.yichao.woo.eaaDev.event.collaboration.command.ServiceLocator;
import com.yigwoo.eaaDev.event.collaboration.command.Order;
import com.yigwoo.eaaDev.event.collaboration.command.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class TraderM {
    public void placeOrder(String symbol, int volume) {
        Order order = new Order(symbol, volume, this);
        outstandingOrders().add(order);
        MessageBus.publishOrderPlacement(order);
    }

    public List<Order> outstandingOrders() {
        List<Order> result = new ArrayList<>();
        ServiceLocator.stockExchanges().forEach(stockExchange -> {
            result.addAll(stockExchange.getOutstandingOrders());
        });
        return result;
    }
}
