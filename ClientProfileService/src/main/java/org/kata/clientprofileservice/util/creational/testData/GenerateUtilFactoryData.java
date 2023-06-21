package org.kata.clientprofileservice.util.creational.testData;


import org.kata.clientprofileservice.util.creational.abstractFactory.*;
import org.springframework.stereotype.Component;


@Component
public class GenerateUtilFactoryData implements GenerateUtilFactory {
    @Override
    public GeneratorAddressTestData getAddressData() {
        return new AddressData();
    }

    @Override
    public GeneratorIndividualTestData getIndividualData() {
        return new IndividualData();
    }

    @Override
    public GeneratorDocumentsTestData getDocumentsData() {
        return new DocumentsData();
    }

    @Override
    public GeneratorSNILSDocTestData getSNILSDocData() {
        return new SNILSDocData();
    }
}
