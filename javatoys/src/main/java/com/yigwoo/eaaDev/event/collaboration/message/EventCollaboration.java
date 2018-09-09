package com.yigwoo.eaaDev.event.collaboration.message;

import com.yigwoo.eaaDev.event.collaboration.command.ServiceLocator;
import com.yigwoo.eaaDev.event.collaboration.command.StockExchange;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventCollaboration {

    @Test
    public void testOrderLifeCycle() {
        TraderM traderA = new TraderM();

        traderA.placeOrder("TW", 1000);
        assertThat(traderA.outstandingOrders().size()).isEqualTo(1);

        executeAllOrders();
        assertThat(traderA.outstandingOrders().size()).isEqualTo(0);

    }

    private void executeAllOrders() {
        ServiceLocator.stockExchanges().forEach(StockExchange::executeAll);
    }
}
