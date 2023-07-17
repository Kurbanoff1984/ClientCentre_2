package org.kata.dto.response;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SNILSDocResponseDto {

    private String uuid;

    private Date receiptDocDate;

    private Date validateDateDoc;

    private String snils;

    private Date issued;

}
