package com.kata.clientprofilerecognition.recognitionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecognitionDTO {
    private String icp;
    private String recognizedDocument;

}
