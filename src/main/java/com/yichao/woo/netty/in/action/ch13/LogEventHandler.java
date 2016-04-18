package com.yichao.woo.netty.in.action.ch13;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Yichao-Woo.
 */
public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent msg) throws Exception {
        String stringBuilder = String.valueOf(msg.getReceived()) + "[" + msg.getSource().toString() +
                "] [" + msg.getLogfile() + "] : " + msg.getMsg();

        System.out.println(stringBuilder);
    }
}
