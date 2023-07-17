package org.kata.clientprofileservice.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.service.impl.IndividualServiceImpl;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.IndividualValidationDto;
import org.kata.dto.response.IndividualResponseDto;
import org.kata.entity.individual.Individual;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/individual")
@RequiredArgsConstructor
public class IndividualController {

    private final IndividualServiceImpl individualService;


    @GetMapping("/getClient")
    public ResponseEntity<IndividualResponseDto> getClient(@RequestParam("id") String id,
                                                           @RequestParam(value = "type", defaultValue = "ICP") String type) {
        return new ResponseEntity<>(individualService.findIndividual(id, type), HttpStatus.OK);
    }




    @RequestMapping("/createClient")
    @ValidParams
    public ResponseEntity<IndividualValidationDto> createTestValidationDto(@RequestBody IndividualValidationDto dto) {
        individualService.createClient(dto);
        return ResponseEntity.ok().body(dto);
    }


}
