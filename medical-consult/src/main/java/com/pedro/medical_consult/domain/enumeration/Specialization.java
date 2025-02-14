package com.pedro.medical_consult.domain.enumeration;

import lombok.Getter;

@Getter
public enum Specialization {

    CARDIOLOGY,
    DERMATOLOGY,
    ENDOCRINOLOGY,
    GASTROENTEROLOGY,
    NEUROLOGY,
    ORTHOPEDICS,
    PEDIATRICS,
    PSYCHIATRY,
    RADIOLOGY,
    UROLOGY;

    private final String formattName;

    Specialization() {
       this.formattName = formattEnumName(formattEnumName(this.name()));
    }

    public String getFormattName() {
        return formattName;
    }

    private static String formattEnumName (String name) {
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}
