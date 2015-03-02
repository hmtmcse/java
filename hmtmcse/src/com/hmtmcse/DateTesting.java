package com.hmtmcse;

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


    }
}
