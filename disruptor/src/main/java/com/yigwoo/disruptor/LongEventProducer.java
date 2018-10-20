package com.yigwoo.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb) {
        /* 从拿下一个 sequence */
        long sequence = ringBuffer.next();

        try {
            /* 然后直接拿的就是 RingBuffer 里面的一个预先分配好的 slot */
            LongEvent longEvent = ringBuffer.get(sequence);
            longEvent.setValue(bb.getLong(0));
        } finally {
            /* Q: 如果上面的 ringBuffer.get 没有成功也需要做这个 publish 的动作吗？*/
            /* A: ringBuffer.next() 的时候就已经将 sequence 位的 slot 拿到了，无论什么情况都需要将
             * 这个 slot publish 掉，不然会使得 disruptor 内部的状态不一致
              * */
            ringBuffer.publish(sequence);
        }

    }
}