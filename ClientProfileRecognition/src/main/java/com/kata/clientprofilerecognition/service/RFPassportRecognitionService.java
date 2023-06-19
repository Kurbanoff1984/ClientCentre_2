package com.kata.clientprofilerecognition.service;

import java.io.IOException;
import java.io.InputStream;

public interface RFPassportRecognitionService  {

    void recognizeRFPassport(InputStream inputStream) throws IOException;
}
