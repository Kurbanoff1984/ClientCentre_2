package org.kata.erroresponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Класс описывающий тело ответа на запрос с потенциальным исключением
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String text;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private HttpStatus httpStatus;
    private int code;

    public ErrorResponse(String text, HttpStatus httpStatus, int code) {
        this.text = text;
        this.date = LocalDateTime.now();
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
