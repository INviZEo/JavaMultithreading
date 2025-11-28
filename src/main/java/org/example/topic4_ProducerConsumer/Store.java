package org.example.topic4_ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Integer> list = new ArrayList<>();

    private final int capacity ;
    private final int threshold;

    public Store(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be greater than zero.");
        this.capacity = capacity;
        this.threshold = capacity / 2;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (list.size() == capacity) {
            System.out.println(Thread.currentThread().getName() + " Буффер полон, ждём");
            wait();
        }
        list.add(value);
        System.out.println(Thread.currentThread().getName() +
                " произвёл: " + value + " → [размер: " + list.size() + "/" + capacity + "]");
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (list.size() <= threshold) {
            System.out.println(Thread.currentThread().getName() + " Мало элементов, ждём добавления");
            wait();
        }
        int value = list.remove(0);
        System.out.println(Thread.currentThread().getName() + " забрал " + value
                + " осталось " + list.size());
        notifyAll();
        return value;
    }
}