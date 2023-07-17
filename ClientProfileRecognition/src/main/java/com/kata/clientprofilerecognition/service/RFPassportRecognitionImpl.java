package com.kata.clientprofilerecognition.service;

import com.kata.clientprofilerecognition.dto.RFPassportRecognitionDto;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

/**
 * Этот сервис распознает данные паспорта, записывает в DTO, проверяет поля DTO на пустоту
 * и возвращает ResponseEntity с DTO либо badRequest
 */


@Slf4j
@Service
public class RFPassportRecognitionImpl implements RFPassportRecognitionService{

    @Override
    public <T> ResponseEntity<T> recognizeRFPassport(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("ClientProfileRecognition/src/main/resources/tessdata");
        tesseract.setLanguage("rus");
        RFPassportRecognitionDto rFPassportRecognitionDto = new RFPassportRecognitionDto();
        try {

            rFPassportRecognitionDto.setIssuedBy(tesseract
                    .doOCR(image, new Rectangle(233,124,500,143))
                    .replaceAll("\n"," ").replaceFirst(".$","\n"));
            rFPassportRecognitionDto.setIssuedDate(tesseract
                    .doOCR(image, new Rectangle(154,283,205,30)));
            rFPassportRecognitionDto.setDivision(tesseract
                    .doOCR(image, new Rectangle(550,258,160,50)));
            rFPassportRecognitionDto.setSurname(tesseract
                    .doOCR(image, new Rectangle(490,750,150,50)));
            rFPassportRecognitionDto.setName(tesseract
                    .doOCR(image, new Rectangle(490,850,150,50)));
            rFPassportRecognitionDto.setPatronymic(tesseract
                    .doOCR(image, new Rectangle(440,900,280,40)));
            rFPassportRecognitionDto.setGender(tesseract
                    .doOCR(image, new Rectangle(360,960,90,40)));
            rFPassportRecognitionDto.setBirthdate(tesseract
                    .doOCR(image, new Rectangle(580,960,215,40)));
            rFPassportRecognitionDto.setBirthplace(tesseract
                    .doOCR(image, new Rectangle(420,1010,330,40)));
            image = ImageHelper.rotateImage(image, -90);
            rFPassportRecognitionDto.setSeries(tesseract
                    .doOCR(image, new Rectangle(165,50,180,70))
                    .replaceAll(" ", ""));
            rFPassportRecognitionDto.setNumber(tesseract
                    .doOCR(image, new Rectangle(330,50,150,70)));
            if (Stream.of(rFPassportRecognitionDto.getBirthdate(),
                            rFPassportRecognitionDto.getDivision(),
                            rFPassportRecognitionDto.getBirthplace(),
                            rFPassportRecognitionDto.getName(),
                            rFPassportRecognitionDto.getGender(),
                            rFPassportRecognitionDto.getIssuedBy(),
                            rFPassportRecognitionDto.getNumber(),
                            rFPassportRecognitionDto.getSeries(),
                            rFPassportRecognitionDto.getSurname(),
                            rFPassportRecognitionDto.getIssuedBy(),
                            rFPassportRecognitionDto.getIssuedDate())
                .anyMatch(String::isEmpty)) {
                log.info("Есть пустые поля");
                return ResponseEntity.badRequest().build();
            }
            log.info("Паспорт распознан");
            return ResponseEntity.ok((T) rFPassportRecognitionDto);

        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
