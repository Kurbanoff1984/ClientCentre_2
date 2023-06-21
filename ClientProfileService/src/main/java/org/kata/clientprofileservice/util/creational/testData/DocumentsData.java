package org.kata.clientprofileservice.util.creational.testData;

import org.kata.clientprofileservice.util.creational.abstractFactory.GeneratorDocumentsTestData;
import org.kata.clientprofileservice.util.testDto.TestDataDocumentsDto;
import org.kata.entity.document.Documents;
import org.modelmapper.ModelMapper;

public class DocumentsData implements GeneratorDocumentsTestData {
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public Documents generateRandomDocument() {
        TestDataDocumentsDto documents = TestDataDocumentsDto.builder().build();
        return modelMapper.map(documents, Documents.class);
    }
}
