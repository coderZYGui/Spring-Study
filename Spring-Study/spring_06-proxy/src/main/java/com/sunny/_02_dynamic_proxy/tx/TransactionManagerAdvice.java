package com.sunny._02_dynamic_proxy.tx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 事务的增强操作
@SuppressWarnings("all")
public class TransactionManagerAdvice implements InvocationHandler {

    // 代理对象中包含的真实对象(对谁做增强)
    private Object target; // 这里是对EmployeeService作增强
    private TransactionManager1 tx;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTx(TransactionManager1 tx) {
        this.tx = tx;
    }

    // 创建一个代理对象
    public <T> T getProxyObject() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),// 类加载器,一般跟上真实对象的类加载器
                target.getClass().getInterfaces(),// 真实对象所实现的接口(JDK动态代理必须要求真实对象有接口)
                this);  // 如何做事务增强的对象
    }

    // 如何为真实对象的方法做增强的具体操作
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 过滤某些方法(对某些方法不增强)
        if (method.getName().equals("queryAll")){
           return method.invoke(target, args);
        }

        Object ret = null;
        tx.begin(); // 开启事务_ 增强操作
        try {
            //------------------------
            ret = method.invoke(target, args); //调用真实对象的方法
            //------------------------
            tx.commit(); // 增强操作
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback(); // 增强操作
        }
        return ret;
    }

    /*class Xx implements InvocationHandler{
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }*/
}
