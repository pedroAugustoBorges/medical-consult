package com.pedro.medical_consult.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TestValidationId implements ConstraintValidator<ValidationId, Long> {

    @Override
    public boolean isValid(Long  id, ConstraintValidatorContext constraintValidatorContext) {
        return id != null && id > 0 ;
    }
}
