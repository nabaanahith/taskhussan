package com.company.models;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    public static final String API_KEY = "910974e178b219f467989e31a7a83776";

    public static String unixTimeTDateTime(String timeStamp) {

        Double unixTimeStamp = Double.valueOf(timeStamp);

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long) (unixTimeStamp * 1000));
        return dateFormat.format(date);
    }

    public  String getDateNow() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.US);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDateNow2() {
        DateFormat dateFormat = new SimpleDateFormat("HH", Locale.US);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
