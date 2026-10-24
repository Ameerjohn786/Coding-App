package com.threads;

import java.util.stream.IntStream;


public class ThreadsExamples {

    public static void main(String[] args) throws InterruptedException {
        //    basicThreadExamples();
        withoutSynchronizedThreads();

    }

    private static void withoutSynchronizedThreads() throws InterruptedException {
        CounterWithoutLock counter = new CounterWithoutLock();
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increament();
            }
        });
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increament();
            }
        });
        t.start();
        t1.start();
        t.join();
        t1.join();
        System.out.println(counter.getCount());
    }

//    private static void synchronizedThreads() {
//
//        int counter = 0;
//
//        Thread t = new Thread(()->{
//            for (int i = 0; i < 3; i++) {
//                counter++;
//            }
//            System.out.println(counter);
//        });
//
//    }

    private static void basicThreadExamples() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 Executing " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread2 Executing " + Thread.currentThread().getName());
            IntStream.rangeClosed(0, 2).forEach(i -> {
                try {
                    System.out.println(i);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        t1.start();
        t1.join();
        t2.start();
    }

    static class CounterWithoutLock {

        private final Object lock = new Object();
        private int count = 0;

        public void increament() {
            synchronized (lock) {
                count++;
            }

        }

        public int getCount() {
            synchronized (lock) {
                return count;
            }
        }
    }
}

