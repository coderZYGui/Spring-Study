package com.sunny._03_di_constructor;

public class Person1 {
    private Cat1 c1;

    public Person1(Cat1 c1) {
        this.c1 = c1;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "c1=" + c1 +
                '}';
    }
}
