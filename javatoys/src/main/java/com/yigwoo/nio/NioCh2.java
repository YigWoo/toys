package com.yigwoo.nio;

import java.nio.ByteBuffer;

public class NioCh2 {

    public static void main(String[] args) {

        ByteBuffer buf = ByteBuffer.allocate(10);

        buf.put((byte) 'H').
                put((byte) 'e').
                put((byte) 'l').
                put((byte) 'l').
                put((byte) 'o')
                .put((byte) 'o');

        System.out.println(buf);

        buf.flip();
        System.out.println(buf);

        byte b1 = buf.get();
        System.out.println((char) b1);

        System.out.println(buf.remaining());

        buf.compact();
        System.out.println(buf);
        byte b = buf.get();
        System.out.println((char) b);
    }
}
