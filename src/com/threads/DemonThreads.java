package com.threads;

public class DemonThreads {
    static int counter = 0;

    public static void main(String[] args) {

        Thread userThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    System.out.println("User Thread Value: " + i);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        userThread.start();
        Thread demonThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    System.out.println("demon Thread Value: " + i);
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        demonThread.setDaemon(true);
        System.out.println(demonThread.isDaemon());
        demonThread.start();
    }
}
