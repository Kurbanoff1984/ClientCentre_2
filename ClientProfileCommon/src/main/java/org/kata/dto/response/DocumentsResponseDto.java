package org.kata.dto.response;


import lombok.*;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentsResponseDto {

    private String uuid;
    private DeathCertDocResponseDto deathCertDocs;
    private Collection<FrgnPassportDocResponseDto> frgnPassportDocs;
    private INNDocResponseDto innDoc;
    private PensionReferenceDocResponseDto pensionReferenceDoc;
    private Collection<RFDrivingLicenseDocResponseDto> rfDrivingLicenseDoc;
    private Collection<RFPassportDocResponseDto> rfPassportDocs;
    private SNILSDocResponseDto snilsDoc;

}
