package org.kata.clientprofileservice.util.creational.abstractFactory;



public interface GenerateUtilFactory {

    GeneratorAddressTestData getAddressData();

    GeneratorIndividualTestData getIndividualData();

    GeneratorDocumentsTestData getDocumentsData();
    GeneratorSNILSDocTestData getSNILSDocData();

}
