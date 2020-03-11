package com.sunny._03cglib_dynamic_proxy.tx;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

// 事务的增强操作
@SuppressWarnings("all")
public class TransactionManagerAdvice2 implements org.springframework.cglib.proxy.InvocationHandler {

    // 代理对象中包含的真实对象(对谁做增强)
    private Object target; // 这里是对EmployeeService作增强
    private TransactionManager2 tx;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTx(TransactionManager2 tx) {
        this.tx = tx;
    }

    // 创建一个代理对象
    public <T> T getProxyObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass()); // 将继承于哪一个类,来做增强
        enhancer.setCallback(this); // 设置增强的对象
        return (T) enhancer.create(); // 创建代理对象
    }

    // 如何为真实对象的方法做增强的具体操作
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
}
