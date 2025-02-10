package com.pedro.medical_consult.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {

    private int status;
    private String details;
    private String title;
    private String developerMessage;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;

}
