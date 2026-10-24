package com.threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws Exception {

        basicExecutorService();
        invokeAllExecutionThread();
        createExecuterService();

    }


    private static void createExecuterService() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
       // Future<String> obj = executorService.execute(createMap());
    }


    private static void shutDownExecutor(ExecutorService executor) throws InterruptedException {
        executor.shutdown();
        if (executor.awaitTermination(2, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    private static void basicExecutorService() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<?> task = executor.submit(() -> {
            System.out.println("Thread1 " + Thread.currentThread().getName());
        });

        Future<Integer> task1 = executor.submit(() -> {
            System.out.println("Thread2 " + Thread.currentThread().getName());
            return 8;
        });
        Future<String> task2 = executor.submit(() -> {
            System.out.println("Thread3 " + Thread.currentThread().getName());
            return "Ameer";
        });
        try {
            task.get();
            int returnInteger = task1.get();
            System.out.println(returnInteger);
            String returnName = task2.get();
            System.out.println(returnName);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            shutDownExecutor(executor);
        }

    }

    private static void invokeAllExecutionThread() throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> "TaskA " + Thread.currentThread().getName());
        tasks.add(() -> "TaskB " + Thread.currentThread().getName());
        tasks.add(() -> "TaskC " + Thread.currentThread().getName());

        try {
            List<Future<String>> results = executor.invokeAll(tasks);
            for (Future<String> future : results) {
                System.out.println(future.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            shutDownExecutor(executor);
        }
    }
}

