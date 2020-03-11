package com.sunny._02_dynamic_proxy.tx;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class TransactionManager1 {
    // 使用JoinPoint类获取被增强方法的信息
    // 必须作为增强方法的第一个参数
    public void begin(JoinPoint jp){
        System.out.println("代理对象:" + jp.getThis().getClass());
        System.out.println("目标对象:" + jp.getTarget().getClass());
        System.out.println("被增强方法的参数:" + Arrays.toString(jp.getArgs()));
        System.out.println("连接点方法签名:" + jp.getSignature());
        System.out.println("当前连接点的类型:" + jp.getKind());
        System.out.println("开启事务");
    }

    public void commit(JoinPoint jp){
        System.out.println("提交事务");
    }

    public void rollback(JoinPoint jp, Throwable exception){
        System.out.println("回滚事务: " + "异常信息:" + exception);
    }

    public void close(JoinPoint jp){
        System.out.println("释放资源");
    }

    public Object aroundMethod(ProceedingJoinPoint jpj){
        Object ret = null;
        System.out.println("开启事务");
        try {
            //System.out.println(".....执行真实对象中的方法");
            ret = jpj.proceed(); // 调用真实对象的方法
            System.out.println("提交事务");
        } catch (Throwable e){
            System.out.println("回滚事务:" + "异常信息:" + e.getMessage());
        } finally {
            System.out.println("释放资源");
        }
        return ret;
    }
}
