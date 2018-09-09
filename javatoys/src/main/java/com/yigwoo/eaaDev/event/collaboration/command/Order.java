package com.yigwoo.eaaDev.event.collaboration.command;

import com.yigwoo.eaaDev.event.collaboration.message.TraderM;
import lombok.Data;

import java.util.Objects;

@Data
public class Order {
    private Integer executedVolume;
    private Integer volume;

    public Order(String symbol, int volume, Trader trader) {

    }

    public Order(String symbol, int volume, TraderM traderM) {

    }

    public boolean isFullyExecuted() {
        return Objects.equals(executedVolume, volume);
    }
}
