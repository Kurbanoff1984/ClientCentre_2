package org.kata.clientprofileservice.service;
import org.springframework.http.ResponseEntity;



public interface StatusVerificationService {
    ResponseEntity<String> verificationStatusForChange(String icp);
}
