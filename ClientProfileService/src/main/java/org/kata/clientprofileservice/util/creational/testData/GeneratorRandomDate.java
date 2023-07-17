package org.kata.clientprofileservice.util.creational.testData;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
@Slf4j
public class GeneratorRandomDate {
    public static Date getRandomDate() {
        Random random = new Random();
        int year = random.nextInt(2023 - 1900) + 1900;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
