package com.yigwoo.java;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTest {

    public static void main(String[] args) {
        LocalDate pmtDue = LocalDate.of(2019, 5, 18);
        LocalDate batchDate = LocalDate.now().minusDays(1);
        System.out.println(pmtDue.until(batchDate, ChronoUnit.DAYS));

        System.out.println(Duration.between(LocalTime.of(9, 45),LocalTime.of(20, 55)).minusMinutes(90).toHours());
        System.out.println(Duration.between(LocalTime.of(9, 45),LocalTime.of(20, 55)).minusMinutes(90).toMinutes());
        System.out.println(ChronoUnit.HOURS.between(LocalTime.of(9, 45), LocalTime.of(20, 55)));


    }
}
