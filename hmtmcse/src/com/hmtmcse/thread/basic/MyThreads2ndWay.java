package com.hmtmcse.thread.basic;

/**
 * Created by Touhid Mia on 24/09/2014.
 */
public class MyThreads2ndWay {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println("Thread 1 = " + i);
                }
            }
        };
        thread.start();
        System.out.println("This Main Thread");

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println("Thread 2 = " + i);
                }
            }
        };
        thread2.start();

    }
}
