package com.kata.clientprofilerecognition.service;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


@Service
public class RFPassportRecognitionImpl implements RFPassportRecognitionService{

    @Override
    public void recognizeRFPassport(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("ClientProfileRecognition/src/main/resources/tessdata");
        tesseract.setLanguage("rus");
        RFPassportDocRecognitionDto rFPassportDocRecognitionDto = new RFPassportDocRecognitionDto();
        try {

            rFPassportDocRecognitionDto.setIssuedBy(tesseract
                    .doOCR(image, new Rectangle(233,124,500,143))
                    .replaceAll("\n"," "));
            rFPassportDocRecognitionDto.setIssuedDate(tesseract
                    .doOCR(image, new Rectangle(154,283,205,30)));
            rFPassportDocRecognitionDto.setDivision(tesseract
                    .doOCR(image, new Rectangle(550,258,160,50)));
            rFPassportDocRecognitionDto.setSurname(tesseract
                    .doOCR(image, new Rectangle(490,750,150,50)));
            rFPassportDocRecognitionDto.setName(tesseract
                    .doOCR(image, new Rectangle(490,850,150,50)));
            rFPassportDocRecognitionDto.setPatronymic(tesseract
                    .doOCR(image, new Rectangle(440,900,280,40)));
            rFPassportDocRecognitionDto.setGender(tesseract
                    .doOCR(image, new Rectangle(360,960,90,40)));
            rFPassportDocRecognitionDto.setBirthdate(tesseract
                    .doOCR(image, new Rectangle(580,960,215,40)));
            rFPassportDocRecognitionDto.setBirthplace(tesseract
                    .doOCR(image, new Rectangle(420,1010,330,40)));
            image = ImageHelper.rotateImage(image, -90);
            rFPassportDocRecognitionDto.setSeries(tesseract
                    .doOCR(image, new Rectangle(165,50,180,70))
                    .replaceAll(" ", ""));
            rFPassportDocRecognitionDto.setNumber(tesseract
                    .doOCR(image, new Rectangle(330,50,150,70)));

        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
