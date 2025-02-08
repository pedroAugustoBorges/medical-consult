package com.pedro.medical_consult.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final DateTimeFormatter DATE_INPUT_FORMAT = DateTimeFormatter.ofPattern("ddMMyyyy");

    public static final DateTimeFormatter DATE_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final DateTimeFormatter TIME_INPUT_FORMAT = DateTimeFormatter.ofPattern("HHmm");

   public static final DateTimeFormatter TIME_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

   public static String formatDate (String date) {

       if (date == null || date.isEmpty()){
           throw new IllegalArgumentException("Date invalid");
       }

       try{
           return LocalDate.parse(date, DATE_INPUT_FORMAT).format(DATE_OUTPUT_FORMAT);
       }catch (DateTimeException e){
            throw new IllegalArgumentException("Format date invalid. Must be ddMMyyyy");
       }

   }

   public static String formatTime (String time){

       if (time == null || time.isEmpty()){
           throw new IllegalArgumentException("Time invalid");
       }

       try {
           return LocalTime.parse(time, TIME_INPUT_FORMAT).format(TIME_OUTPUT_FORMAT);
       }catch (DateTimeException e){
           throw new IllegalArgumentException("Format local invalid. Must be HHmm");
       }
   }
   

}
