package com.sunny.lifecycle;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype") // 默认不写就是单例的
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SomeBean {
    public SomeBean() {
        System.out.println("构造SomeBean对象");
    }

    @PreDestroy // 销毁对象之前执行
    public void close() {
        System.out.println("销毁方法");
    }

    @PostConstruct // 构建对象之后执行
    public void open() {
        System.out.println("初始化方法");
    }
    public void doWork() {
        System.out.println("工作");
    }
}
