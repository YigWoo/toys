package com.yichao.woo.netty.in.action.ch13;

import java.net.InetSocketAddress;

/**
 * Created by Yichao-Woo.
 */
class LogEvent {

    static final byte SEPARATOR = '=';

    private final InetSocketAddress source;
    private final String logfile;
    private final String msg;
    private final long received;

    public LogEvent(String logfile, String msg) {
        this(null, logfile, msg, -1);
    }

    LogEvent(InetSocketAddress source, String logfile, String msg, long received) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }


    InetSocketAddress getSource() {
        return source;
    }

    String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }

    long getReceived() {
        return received;
    }
}
