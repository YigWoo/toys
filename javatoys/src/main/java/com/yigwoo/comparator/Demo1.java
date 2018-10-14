package com.yigwoo.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) {
        List<Integer> list = new Random(209).ints(32L)
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        list.sort(logging((a, b) -> a - b));

        System.out.println(list);
    }

    public static Comparator<Integer> logging(Comparator<Integer> c) {
        return (a, b) -> {
            int r = c.compare(a, b);
            System.err.printf("%,14d    %,14d    %,14d\n", a, b, r);
            return r;
        };
    }
}
