package com.pedro.medical_consult.handler;

import com.pedro.medical_consult.exception.BadRequestException;
import com.pedro.medical_consult.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .title("Bad Request Exception, Check the documentation")
                        .details(bre.getMessage())
                        .timestamp(LocalDateTime.now())
                        .developerMessage(bre.getClass().getName())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

}
