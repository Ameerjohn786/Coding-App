package com.threads;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExamples {

    private static Map<Integer, Employee> employMap;

    public static void main(String[] args) {

        basicCompletableFuture();
        EmployFuture();
        Employee saveData = loadEmployData();

    }

    private static Employee loadEmployData() {

        Employee emp = new Employee(1, "Ameer", 70000);
        employMap.put(1, emp);
        return emp;

    }

    private static void EmployFuture() {

        CompletableFuture<Employee> employFuture = CompletableFuture.supplyAsync(() -> {
            return loadEmployData();
        });
    }

    private static void basicCompletableFuture() {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {

            System.out.println("Ameer john" + Thread.currentThread().getName());
        });
        future.join();

        CompletableFuture<String> submitFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Ameer";
        }).thenApply(name -> {
            System.out.println(Thread.currentThread().getName());
            return name.toLowerCase();
        });

        String submitName = submitFuture.join();
        System.out.println(submitName + " " + Thread.currentThread().getName());
    }
}
