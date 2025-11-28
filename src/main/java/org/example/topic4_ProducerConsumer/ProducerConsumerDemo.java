package org.example.topic4_ProducerConsumer;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Store store = new Store(16);
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}