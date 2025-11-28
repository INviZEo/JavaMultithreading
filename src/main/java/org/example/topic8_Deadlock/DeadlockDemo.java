package org.example.topic8_Deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " захватил lock1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(Thread.currentThread().getName() + " хочет взять lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " захватил lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " захватил lock2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " хочет взять lock1");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " захватил lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}