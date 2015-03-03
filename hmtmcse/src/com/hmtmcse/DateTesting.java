package com.hmtmcse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by touhid on 2/03/2015.
 */
public class DateTesting {

    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println(date);

        //Last Month
        Calendar lastMonth = Calendar.getInstance();
        lastMonth.setTime(new Date());
        lastMonth.add(Calendar.MONTH, -1);
        lastMonth.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(lastMonth.getTime());


        // Current Month
        Calendar currentMonth = Calendar.getInstance();
        currentMonth.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(currentMonth.getTime());

        //Convert Calendar to Date
        Calendar calendar1 = Calendar.getInstance();
        Date date2 = calendar1.getTime();
        System.out.println(date2);


        // Extract Calendar
        Calendar myCalendar = Calendar.getInstance();
        int year       = myCalendar.get(Calendar.YEAR);
        int month      = myCalendar.get(Calendar.MONTH);
        int dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek  = myCalendar.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = myCalendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth= myCalendar.get(Calendar.WEEK_OF_MONTH);

        int hour       = myCalendar.get(Calendar.HOUR);
        int hourOfDay  = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute     = myCalendar.get(Calendar.MINUTE);
        int second     = myCalendar.get(Calendar.SECOND);
        int millisecond= myCalendar.get(Calendar.MILLISECOND);

        System.out.println(myCalendar.getTime());

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("weekOfYear = " + weekOfYear);
        System.out.println("weekOfMonth = " + weekOfMonth);

        System.out.println("hour = " + hour);
        System.out.println("hourOfDay = " + hourOfDay);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);
        System.out.println("millisecond = " + millisecond);


        //Convert Date to String
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy");
        String stringDate = simpleDateFormat.format(new Date());
        System.out.println(stringDate);

        //Convert String to Date
        SimpleDateFormat simpleDateFormatStringToDate = new SimpleDateFormat("dd/M/yyyy");
        String stringToDate = "02/03/2015";
        try {
            Date date1 = simpleDateFormatStringToDate.parse(stringToDate);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }





    }
}
