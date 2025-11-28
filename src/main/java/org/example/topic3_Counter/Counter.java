package org.example.topic3_Counter;

public class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
