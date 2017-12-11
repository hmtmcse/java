package com.hmtmcse.thread;

/**
 * Created by Touhid Mia on 24/09/2014.
 */
public class HelloRunnable implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("Thread 1" + i);
        }
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
        (new Thread(new HelloRunnable())).start();
    }

}
