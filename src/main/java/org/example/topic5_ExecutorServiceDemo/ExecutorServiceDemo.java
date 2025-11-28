package org.example.topic5_ExecutorServiceDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        AtomicInteger taskNum = new AtomicInteger();
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> System.out.println(taskNum.getAndIncrement() + " "
                    + Thread.currentThread().getName()));
        }
        executorService.shutdown();
        if (!executorService.awaitTermination(3000, TimeUnit.MILLISECONDS)) {
            System.out.println("Не все потоки завершили работу");
            executorService.shutdownNow();
        }
    }
}
