package org.kata.clientprofileservice.util.testDto;


import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDataSNILSDocDto {
    private String uuid;
    private Date receiptDocDate;
    private Date validateDateDoc;
    private String snils;
    private Date issued;


}
