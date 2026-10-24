package com.designpatterns.factorydesign;

public class FactoryDesign {

    public static void main(String[] args) {
        Vehicle obj = VehicleFactory.getInstance("bike");
        obj.drive();
    }
}
