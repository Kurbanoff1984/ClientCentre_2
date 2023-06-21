package org.kata.clientprofileservice.util.creational.testData;

import org.kata.clientprofileservice.util.creational.abstractFactory.GeneratorSNILSDocTestData;
import org.kata.clientprofileservice.util.testDto.TestDataSNILSDocDto;
import org.kata.entity.document.SNILSDoc;
import org.modelmapper.ModelMapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class SNILSDocData implements GeneratorSNILSDocTestData {
    @Override
    public SNILSDoc generateRandomSNILSDoc() {
        ModelMapper modelMapper = new ModelMapper();
        Random random = new Random();
        TestDataSNILSDocDto snilsDoc = TestDataSNILSDocDto.builder()
                .receiptDocDate(getRandomDate())
                .validateDateDoc(getRandomDate())
                .issued(getRandomDate())
                .snils(String.valueOf(Math.abs(random.nextLong()) % 100000000000L))
                .build();
        return modelMapper.map(snilsDoc, SNILSDoc.class);
    }

    protected Date getRandomDate() {
        Random random = new Random();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, random.nextInt(50) + 1965);
        calendar.set(Calendar.MONTH, random.nextInt(12));
        calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1);
        return calendar.getTime();
    }
}
