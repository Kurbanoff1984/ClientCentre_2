package org.kata.clientprofileservice.validation.databaseValidation;

public interface IndividualValidation {
    void isExistIndividualByIcp(String icp);

    void isExistIndividualByUuid(String uuid);
}
