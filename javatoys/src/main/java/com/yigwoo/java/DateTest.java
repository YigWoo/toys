package com.yigwoo.java;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateTest {

    public static void main(String[] args) {
        LocalDate pmtDue = LocalDate.of(2019, 5, 18);
        LocalDate batchDate = LocalDate.now().minusDays(1);
        System.out.println(pmtDue.until(batchDate, ChronoUnit.DAYS));
    }
}
