package com.miaisoft.threads.basic;

/**
 * Created by Touhid Mia on 24/09/2014.
 */
public class MyThreads2ndWay {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1 = " + i);
                }
            }
        };
        thread.start();
        System.out.println("This Main Thread");

    }
}
