package org.example.topic1_MyThread;

import static java.lang.System.out;

public class MyThread extends Thread {
    @Override
    public void run() {
         out.println("Thread [" + currentThread().getName() + "] says: Hello from thread!");
    }
}
