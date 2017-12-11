package com.hmtmcse.thread.advance;

public class Test {

    public static void main(String[] args) {
        new ParallelTask() {
            @Override
            public void task() {
                for (int i = 0; i < 100; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1 = " + i);
                }
            }
        }.fire();
    }
}
