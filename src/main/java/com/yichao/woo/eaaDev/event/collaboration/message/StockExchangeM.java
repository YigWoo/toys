package com.yichao.woo.eaaDev.event.collaboration.message;

public class StockExchangeM {
    public StockExchangeM() {
    }

    public void subscribe() {
        MessageBus.subscribeToOrders(this);
    }
}
