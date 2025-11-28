package org.example.topic6_Interrupt;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Работаю...");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
