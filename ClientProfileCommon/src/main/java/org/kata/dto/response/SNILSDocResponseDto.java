package org.kata.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SNILSDocResponseDto {

    private String uuid;

    private Date receiptDocDate;

    private Date validateDateDoc;

    private String snils;

    private Date issued;

}
