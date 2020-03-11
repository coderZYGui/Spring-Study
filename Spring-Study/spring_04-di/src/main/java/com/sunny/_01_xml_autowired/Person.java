package com.sunny._01_xml_autowired;

// 需求: 让Spring帮我们创建Person对象,而Person对象还需要依赖Dog对象;所以需要创建两个Bean
public class Person {
    private Dog dog;

    public void setDog(Dog dog){
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                '}';
    }
}
