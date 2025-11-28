package org.example.topic1_MyThread;

public class ThreadExtendDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        Thread thread1 = new MyThread();
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ожидание потоков прервано — завершаем программу");
            return; // Вова, он здесь для читаемости, но скажи если это избыточно!)
        }
    }
}
