package org.kata.clientprofileservice.validation;

public interface IndividualValidation {
    void isExistIndividualByIcp(String icp);

    void isExistIndividualByUuid(String uuid);
}
