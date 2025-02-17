package com.pedro.medical_consult.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TestValidationId.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidationId {
    String message() default "Id invalid";
    Class<?> [] groups () default {};
    Class<? extends Payload> [] payload () default  {};
}
