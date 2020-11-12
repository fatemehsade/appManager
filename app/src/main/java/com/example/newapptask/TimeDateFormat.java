package com.example.newapptask;

import java.text.DateFormat;
import java.util.Date;

public class TimeDateFormat {
    public static String getDateFormat(Date date){
        return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
    }
    public static String getTimeFormat(Date date){
        return DateFormat.getTimeInstance(DateFormat.SHORT).format(date);
    }
}
