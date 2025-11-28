package org.example.topic2_Runnable;

public class RunnableLambdaDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Task "
                + Thread.currentThread()
                .getName()
                .replaceAll("[^0-9]", "") + " is running!");
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
