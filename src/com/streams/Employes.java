package com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Employes {
    @Override
    public String toString() {
        return "Employes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    private int id;
    private String name;
    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employes(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public static void main(String[] args) {


        List<Employes> emp = Arrays.asList(new Employes(
                        1, "John", 50000),
                new Employes(2, "David", 90000),
                new Employes(3, "Ameer", 75000),
                new Employes(3, "Sam", 60000),
                new Employes(5, "Kaja", 70000));

        System.out.println(emp.stream().mapToInt(Employes::getSalary).sum());

        System.out.println(emp.stream().map(Employes::getSalary)
                .reduce(0, Integer::sum) / emp.size());

        emp.stream().filter(e -> e.getSalary() > 7000).toList();
        System.out.println(emp.stream()
                .max(Comparator.comparingInt(Employes::getSalary)).map(Employes::getName).get());

    }
}