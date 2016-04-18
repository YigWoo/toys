package com.yichao.woo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yichao-Woo.
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        List<OOMObject> list = new ArrayList<>();

        //noinspection InfiniteLoopStatement
        while (true) {
            list.add(new OOMObject());
        }

    }
}
