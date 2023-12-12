package com.solvd.hardwarestore1;

public class ThreadWithRunnable implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello with runnable");
    }
}
