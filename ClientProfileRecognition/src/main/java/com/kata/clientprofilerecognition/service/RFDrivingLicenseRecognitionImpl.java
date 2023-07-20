package com.kata.clientprofilerecognition.service;

import com.kata.clientprofilerecognition.dto.RFDrivingLicenseRecognitionDto;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Этот сервис распознает данные водительского удостоверения, записывает в DTO, проверяет поля DTO на пустоту
 * и возвращает ResponseEntity с DTO либо badRequest
 */

@Service
@Slf4j
public class RFDrivingLicenseRecognitionImpl implements RFDrivingLicenseRecognitionService{
    @Override
    public <T> ResponseEntity<T> recognizeRFDrivingLicense(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("ClientProfileRecognition/src/main/resources/tessdata");
        RFDrivingLicenseRecognitionDto rfDrivingLicenseRecognitionDto = new RFDrivingLicenseRecognitionDto();
        try {

            tesseract.setLanguage("rus");
            rfDrivingLicenseRecognitionDto.setSurname(tesseract
                    .doOCR(image, new Rectangle(365,90,120,30)));
            rfDrivingLicenseRecognitionDto.setName(tesseract
                    .doOCR(image, new Rectangle(365, 155,120, 30)));
            rfDrivingLicenseRecognitionDto.setPatronymic(tesseract
                    .doOCR(image, new Rectangle(500, 150,165, 35)));
            rfDrivingLicenseRecognitionDto.setBirthdate(tesseract
                    .doOCR(image, new Rectangle(365, 200,140, 35)));
            rfDrivingLicenseRecognitionDto.setBirthplace(tesseract
                    .doOCR(image, new Rectangle(365, 240,300, 35)));
            rfDrivingLicenseRecognitionDto.setIssued(tesseract
                    .doOCR(image, new Rectangle(365, 290,160, 35)));
            rfDrivingLicenseRecognitionDto.setExpiryDate(tesseract
                    .doOCR(image, new Rectangle(650, 290,160, 35)));
            rfDrivingLicenseRecognitionDto.setIssuedBy(tesseract
                    .doOCR(image, new Rectangle(365, 325,170, 35)));
            rfDrivingLicenseRecognitionDto.setSeriesRDL(tesseract
                    .doOCR(image, new Rectangle(365, 385,80, 35))
                    .replaceAll(" ", ""));
            rfDrivingLicenseRecognitionDto.setNumberRDL(tesseract
                    .doOCR(image, new Rectangle(445, 385,100, 35)));
            rfDrivingLicenseRecognitionDto.setLocation(tesseract
                    .doOCR(image, new Rectangle(365, 415,300, 35)));
            ArrayList<String> category = new ArrayList<>();
            tesseract.setLanguage("eng");
            category.add(tesseract.doOCR(image, new Rectangle(380, 480, 20, 25)));
            category.add((tesseract.doOCR(image, new Rectangle(415, 480, 20, 25))));
            category.add((tesseract.doOCR(image, new Rectangle(453, 480, 20, 25))));
            rfDrivingLicenseRecognitionDto.setCategory(category);
            if (Stream.of(rfDrivingLicenseRecognitionDto.getBirthdate(),
                            rfDrivingLicenseRecognitionDto.getExpiryDate(),
                            rfDrivingLicenseRecognitionDto.getName(),
                            rfDrivingLicenseRecognitionDto.getIssued(),
                            rfDrivingLicenseRecognitionDto.getIssuedBy(),
                            rfDrivingLicenseRecognitionDto.getBirthplace(),
                            rfDrivingLicenseRecognitionDto.getLocation(),
                            rfDrivingLicenseRecognitionDto.getNumberRDL(),
                            rfDrivingLicenseRecognitionDto.getSurname(),
                            rfDrivingLicenseRecognitionDto.getPatronymic(),
                            rfDrivingLicenseRecognitionDto.getSeriesRDL())
                    .anyMatch(String::isEmpty) || category.stream().anyMatch(String::isEmpty)) {
                log.info("Документ не распознан, есть пустые поля");
                return ResponseEntity.badRequest().build();
            }
            log.info("Водительское удостоверение распознано");
            return ResponseEntity.ok((T) rfDrivingLicenseRecognitionDto);

        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
