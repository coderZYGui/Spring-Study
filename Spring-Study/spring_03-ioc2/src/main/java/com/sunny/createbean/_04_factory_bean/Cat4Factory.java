package com.sunny.createbean._04_factory_bean;

import org.springframework.beans.factory.FactoryBean;


public class Cat4Factory implements FactoryBean<Cat4> {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    // 实例工厂的方法(对比方式三,这种方式固定了工厂实例方法)
    public Cat4 getObject() throws Exception {
        System.out.println("name=:" + name);
        Cat4 cat4 = new Cat4();
        return cat4;
    }

    public Class<?> getObjectType() {
        return Cat4.class;
    }
}
