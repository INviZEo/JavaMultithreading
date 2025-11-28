package org.example.topic9_RaceCondition;

public class RaceConditionDemo {
    static int count = 0;
    static final Object lock = new Object();

    public static int raceCondition() throws InterruptedException {
        count = 0;
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        return count;
    }

    public static int noRaceCondition() throws InterruptedException {
        count = 0;

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (lock) {
                    count++; // Или AtomicInteger + incrementAndGet() тогда без блока synchronized
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (lock) {
                    count++; // Или AtomicInteger + incrementAndGet() тогда без блока synchronized
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(raceCondition());
        System.out.println(noRaceCondition());
    }
}