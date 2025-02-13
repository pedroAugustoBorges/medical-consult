package com.pedro.medical_consult.exception;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {

    private final String field;
    private final String fieldMessage;

}
