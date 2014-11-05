package com.miaisoft.threads.basic;

/**
 * Created by Touhid Mia on 24/09/2014.
 */
public class MyThreadsByRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThreadsByRunnable 1 = " + i);
        }
    }
}
