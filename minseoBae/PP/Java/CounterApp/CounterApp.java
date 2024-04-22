package com.example.day15.실습.CounterApp;

public class CounterApp {
    public static void main(String[] args) {
        Thread increment = new Thread(new IncrementCounter());
        Thread decrement = new Thread(new DecrementCounter());

        increment.start();
        decrement.start();
    }
}
