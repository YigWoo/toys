package com.yigwoo.eaaDev.event.collaboration.message;

public class StockExchangeM {
    public StockExchangeM() {
    }

    public void subscribe() {
        MessageBus.subscribeToOrders(this);
    }
}
