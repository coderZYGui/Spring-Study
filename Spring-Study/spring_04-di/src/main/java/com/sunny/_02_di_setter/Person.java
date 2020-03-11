package com.sunny._02_di_setter;


public class Person {
    private Cat c1;

    public void setC1(Cat c1) {
        this.c1 = c1;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "c1=" + c1 +
                '}';
    }
}
