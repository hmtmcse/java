package com.hmtmcse.basic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Touhid Mia on 14/02/2016.
 */
public class DateTimeFormater {
    public static void main(String args[]) {

        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("dd MMMM yyyy hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(dNow));
    }
}
