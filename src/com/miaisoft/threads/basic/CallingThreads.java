package com.miaisoft.threads.basic;

/**
 * Created by Touhid Mia on 24/09/2014.
 */
public class CallingThreads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Threads Started.");
        new MyThreads().start();
        System.out.println("This is Other Work.");

        //        Calling Runnable Thread
        new Thread(new MyThreadsByRunnable()).start();

        for (int i = 0; i < 100; i++){
            Thread.sleep(2000);
            System.out.println("Main Thread  = " + i);
        }


    }
}
