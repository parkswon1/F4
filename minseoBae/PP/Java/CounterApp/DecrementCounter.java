package com.example.day15.실습.CounterApp;

public class DecrementCounter implements Runnable{
    public void run() {
        for(int i = 100; i >= 1; i--) {
            System.out.println("Decrement: { " + i + " }");
        }
    }
}
