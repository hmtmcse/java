package com.hmtmcse.thread.advance;


public abstract class ParallelTask {

    public abstract void task();

    public void fire(){
        new Thread(){
            @Override
            public void run() {
                task();
            }
        }.start();
    }

}
