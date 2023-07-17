package org.kata.clientprofileservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.kata.clientprofileservice.repository.AddressRepo;
import org.kata.clientprofileservice.repository.IndividualRepo;

import org.kata.clientprofileservice.service.TestDataIndividualService;
import org.kata.clientprofileservice.util.creational.abstractFactory.GenerateUtilFactory;
import org.kata.entity.document.Documents;
import org.kata.entity.document.SNILSDoc;
import org.kata.entity.individual.Address;
import org.kata.entity.individual.Individual;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TestDataIndividualServiceImpl implements TestDataIndividualService {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final AddressRepo addressRepo;
    private final IndividualRepo individualRepo;
    private final GenerateUtilFactory generateUtil;
    private static final String TOPIC = "TestUsers" ;

    @SneakyThrows
    @Override
    public void createIndividuals(int count) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Individual> individualList = new ArrayList<>();
        if (count <= 0) {
            throw new IllegalArgumentException("The number of objects created must be greater than zero.");
        }

        for (int i = 0; i < count; i++) {
            Individual individual = individualRepo.save(generateUtil.getIndividualData().generateRandomIndividual());
            Address address = addressRepo.save(generateUtil.getAddressData().generateRandomAddress());
            Documents documents = generateUtil.getDocumentsData().generateRandomDocument();
            SNILSDoc snilsDoc = generateUtil.getSNILSDocData().generateRandomSNILSDoc();


            address.setIndividual(individual);
            individual.setAddress(new ArrayList<>() {{
                add(address);
            }});

            documents.setIndividual(individual);
            individual.setDocuments(documents);

            snilsDoc.setDocuments(documents);
            documents.setSnilsDoc(snilsDoc);


            individualList.add(individual);
            individualRepo.save(individual);
        }
        kafkaTemplate.send(TOPIC, objectMapper.writeValueAsBytes(individualList));
    }
}
