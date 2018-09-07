package com.yigwoo.eaaDev.event.collaboration.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServiceLocator {
    public static List<StockExchange> stockExchanges = new ArrayList<>();

    static  {
        StockExchange twExchange = new StockExchange();
        twExchange.setSymbol("TW");
        stockExchanges.add(twExchange);
        
        StockExchange swExchange = new StockExchange();
        swExchange.setSymbol("SW");
        stockExchanges.add(swExchange);
    }


    public static StockExchange stockExchangeFor(String symbol) {
        return stockExchanges()
                .stream()
                .filter(stockExchange -> Objects.equals(stockExchange.getSymbol(), symbol))
                .findFirst().orElse(null);
    }

    public static List<StockExchange> stockExchanges() {
        return stockExchanges;
    }
}
