package com.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employ implements Cloneable {

    private String name;
    private int employSalary;
    private Address address;
    private List<Skills> skills;

    public Employ(String name, int employSalary, Address address) {
        this.name = name;
        this.employSalary = employSalary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmploySalary() {
        return employSalary;
    }

    public void setEmploySalary(int employSalary) {
        this.employSalary = employSalary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", employSalary=" + employSalary +
                ", address=" + address +
                '}';
    }

    @Override
    protected Employ clone() throws CloneNotSupportedException {

        Employ employ = (Employ) super.clone();
        employ.address = new Address(this.address.getCity());
        employ.skills = new ArrayList<>(this.skills);
        return employ;
    }

   /* protected Object clone() throws CloneNotSupportedException {

        return (Employ) super.clone();
        return employ;
    }*/
}
