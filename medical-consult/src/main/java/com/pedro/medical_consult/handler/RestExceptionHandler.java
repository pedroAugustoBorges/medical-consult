package com.pedro.medical_consult.handler;

import com.pedro.medical_consult.exception.BadRequestException;
import com.pedro.medical_consult.exception.BadRequestExceptionDetails;
import com.pedro.medical_consult.exception.ValidationExceptionDetails;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Log4j2
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

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException (MethodArgumentNotValidException exceptionThrow){
        List<FieldError> fieldErrors = exceptionThrow.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField)
                .collect(Collectors.joining(", "));

        String fieldsMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        return new ResponseEntity<> (
                ValidationExceptionDetails.builder()
                        .title("Validation exception, invalid fields")
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .developerMessage(exceptionThrow.getClass().getName())
                        .field(fields)
                        .fieldMessage(fieldsMessages)
                        .details("Check the field erros")
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

}
