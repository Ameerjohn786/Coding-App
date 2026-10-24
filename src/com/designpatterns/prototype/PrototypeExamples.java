package com.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeExamples {

    public static void main(String[] args) throws CloneNotSupportedException {

        Address address = new Address("Chennai");
        List<String> skills = new ArrayList<>();
        skills.add("Kafka");
        Employ emp1 = new Employ("john", 800, address);
        emp1.setName("Ameer");
        emp1.setEmploySalary(8000);
        System.out.println(emp1);

        Employ emp2 = (Employ) emp1.clone();
        System.out.println(emp2);

        System.out.println(emp1 == emp2);
        System.out.println(emp1.equals(emp2));
    }
}
