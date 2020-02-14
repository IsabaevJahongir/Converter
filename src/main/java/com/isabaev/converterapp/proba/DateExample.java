package com.isabaev.converterapp.proba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("14.02.2020");
        Date current = new Date();

        current.setHours(0);
        current.setMinutes(0);
        current.setSeconds(0);


        System.out.println("Now: " + current);
        System.out.println("Date: " + date);



        if(date.getDate() == current.getDate() + 1 && date.getMonth() == current.getMonth() && date.getYear() == current.getYear()){
            System.out.println("Даты совпадают");
        }else {
            System.out.println("Даты не совпадают");
        }

        System.out.println(date.compareTo(current));
    }

}
