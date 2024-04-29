package com.example.day15.실습.CounterApp;

public class IncrementCounter implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println("Increment: { " + i + " }");
        }
    }
}
