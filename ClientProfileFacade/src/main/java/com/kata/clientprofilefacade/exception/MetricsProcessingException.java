package com.kata.clientprofilefacade.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MetricsProcessingException extends RuntimeException {
    public MetricsProcessingException(String message) {
        super(message);
        log.error("MetricsProcessingException: {}",message);
    }
}
