package com.yigwoo.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo2 {

    public static void main(String[] args) {
        ArrayList<ItemScore> itemScores = new Random(284397476).ints(100L)
                .map(Math::abs)
                .mapToDouble(i -> Math.sqrt((double) i))
                .mapToObj(operand -> {
                    ItemScore itemScore = new ItemScore();
                    itemScore.setScore(operand);
                    return itemScore;
                })
                .collect(Collectors.toCollection(ArrayList::new));

//        list.sort((a, b) -> a < b ? -1 : a > b ? 1 : 0);
        itemScores.sort(Comparator.comparing(ItemScore::getScore).reversed());
        itemScores.sort((o1, o2) -> o2.getScore().compareTo(o1.getScore()));

        System.out.println(itemScores);
    }
}
