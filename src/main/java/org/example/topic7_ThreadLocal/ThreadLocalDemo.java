package org.example.topic7_ThreadLocal;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                threadLocal.set(threadLocal.get() + 1);
            }
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            threadLocal.remove();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                threadLocal.set(threadLocal.get() + 1);
            }
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            threadLocal.remove();
        });

        t1.start();
        t2.start();
    }
}
