package com.hmtmcse.time;

import java.util.TimerTask;
import java.util.Date;

/**
 * Created by Touhid Mia on 01/08/2016.
 */
public class ScheduledTask extends TimerTask {
    Date now; // to display current time

    // Add your task here
    public void run() {
        now = new Date(); // initialize date
        System.out.println("Time is :" + now); // Display current time
    }
}
