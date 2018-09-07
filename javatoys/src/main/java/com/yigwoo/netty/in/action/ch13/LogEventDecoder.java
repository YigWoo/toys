package com.yigwoo.netty.in.action.ch13;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * Created by Yichao-Woo.
 */
public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
        ByteBuf content = msg.content();
        int index = content.indexOf(0, content.readableBytes(), LogEvent.SEPARATOR);
        ByteBuf slice1 = content.slice(0, index);
        byte[] bytes = new byte[slice1.readableBytes()];
        slice1.getBytes(slice1.readerIndex(), bytes);

        String fileName = new String(bytes);


        ByteBuf slice2 = content.slice(index + 1, content.readableBytes());
        byte[] bytes1 = new byte[slice2.readableBytes()];
        slice2.getBytes(slice2.readerIndex(), bytes1);

        String logMsg = new String(bytes1);

        LogEvent logEvent = new LogEvent(msg.sender(), fileName, logMsg, System.currentTimeMillis());
        out.add(logEvent);
    }
}
