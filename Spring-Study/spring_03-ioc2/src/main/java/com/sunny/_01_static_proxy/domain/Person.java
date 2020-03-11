package com.sunny._01_static_proxy.domain;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;

    public Person(){
        System.out.println("Person对象创建啦!");
    }
}
