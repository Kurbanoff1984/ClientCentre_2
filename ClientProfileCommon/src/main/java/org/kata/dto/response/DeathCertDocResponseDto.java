package org.kata.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeathCertDocResponseDto {

    private String uuid;

    private String message;

    private String series;

    private String number;

    private Date issued;

    private String departmentDoc;

    private Date getDateDoc;

}
