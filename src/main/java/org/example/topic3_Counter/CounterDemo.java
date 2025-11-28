package org.example.topic3_Counter;

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 44440; i++) {
                counter.increment();
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 44440; i++) {
                counter.increment();
            }
        });
        thread2.start();

        thread.join();
        thread2.join();
        System.out.println(counter.getCount());
    }
}
