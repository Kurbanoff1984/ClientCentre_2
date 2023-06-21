package org.kata.clientprofileservice.util.testDto;

import lombok.*;
import org.kata.entity.document.*;
import org.kata.entity.individual.Individual;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Getter
@Setter
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDataDocumentsDto {
    private String uuid;
//    private Individual individual;
    private DeathCertDoc deathCertDocs;
    private Collection<FrgnPassportDoc> frgnPassportDocs;
    private INNDoc innDoc;
    private PensionReferenceDoc pensionReferenceDoc;
    private Collection<RFDrivingLicenseDoc> rfDrivingLicenseDoc;
    private Collection<RFPassportDoc> rfPassportDocs;
    private SNILSDoc snilsDoc;
}
