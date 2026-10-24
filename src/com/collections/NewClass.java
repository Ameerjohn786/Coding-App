package com.collections;

public class NewClass {

    public static void main(String[] args) {

        Data d1 = new Data(1, "sd");
        Data d2 = new Data(1, "sd");
        System.out.println(d1.equals(d2));
    }
}

class Data {
    public Data(int i, String sd) {
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}