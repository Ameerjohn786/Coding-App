package com.designpatterns.factorydesign;

public class VehicleFactory {

    public static Vehicle getInstance(String type) {

        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        throw new IllegalArgumentException("Invalid type");
    }
}