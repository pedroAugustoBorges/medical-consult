package com.pedro.medical_consult.util;

public class CrmFormatter {

    public static String formatter(String crm) {

        crm = crm.trim();

        int lenght = crm.length();

        if (lenght < 4) {
            throw new IllegalArgumentException("Format crm invalid. Must be format 'NNNNNNSS, Where 'NNNNNN' are numbers and 'SS' are acronym of state");

        }

        String states = crm.substring(crm.length() - 2).toUpperCase();

        if (!Character.isLetter(crm.charAt(crm.length() - 2)) && Character.isLetter(crm.charAt(crm.length() - 1))) {
            throw new IllegalArgumentException("The last two characters must be letters, representing acronym of state");
        }

        String numbers = crm.substring(crm.length() - 2);

        if (!numbers.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("The first characters must be numbers digits");
        }

        return String.format("%s/%s", numbers, states);


    }
}
