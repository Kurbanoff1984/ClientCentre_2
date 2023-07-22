package org.kata.clientprofileservice.util.creational.testData;

import org.kata.clientprofileservice.util.creational.abstractFactory.GeneratorSNILSDocTestData;
import org.kata.clientprofileservice.util.testDto.TestDataSNILSDocDto;
import org.kata.entity.document.SNILSDoc;
import org.modelmapper.ModelMapper;

import java.util.Random;

public class SNILSDocData implements GeneratorSNILSDocTestData {
    @Override
    public SNILSDoc generateRandomSNILSDoc() {
        ModelMapper modelMapper = new ModelMapper();
        TestDataSNILSDocDto snilsDoc = TestDataSNILSDocDto.builder()
                .receiptDocDate(GeneratorRandomDate.getRandomDate())
                .validateDateDoc(GeneratorRandomDate.getRandomDate())
                .issued(GeneratorRandomDate.getRandomDate())
                .snils(getRandomSnils())
                .build();
        return modelMapper.map(snilsDoc, SNILSDoc.class);
    }

    protected String getRandomSnils() {
        Random random =  new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            int randomD = random.nextInt(10);
            if (i == 3 || i == 7) {
                sb.append("-");
            } else if (i == 11) {
                sb.append(" ");
            } else {
                sb.append(randomD);
            }
        }
        return sb.toString();
    }
}
