package com.sunny.lifecycle;

/**
 * 模拟数据库连接池
 * 当使用连接池的时候,都需要初始化和销毁,使用Spring IoC容器后,如何
 * 让容器帮助我们进行初始化和销毁呢?
 */
public class MyDataSource {

    public MyDataSource(){
        System.out.println("创建对象...");
    }

    public void open(){
        System.out.println("开启资源...");
    }

    public void close(){
        System.out.println("销毁资源...");
    }

    public void doWork(){
        System.out.println("工作...");
    }
}
