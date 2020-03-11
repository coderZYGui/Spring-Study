package com.sunny.di;

import javax.annotation.Resource;

public class Person {

    //@Autowired
    @Resource(name = "cat1")
    private Cat c1;

/*    @Resource
    public void setC1(Cat c1) {
        this.c1 = c1;
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "c1=" + c1 +
                '}';
    }
}
