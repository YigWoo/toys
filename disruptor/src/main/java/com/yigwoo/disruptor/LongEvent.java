package com.yigwoo.disruptor;

import lombok.Data;

@Data
public class LongEvent {
    private long value;

    public void set(Long value) {
        this.value = value;
    }
}