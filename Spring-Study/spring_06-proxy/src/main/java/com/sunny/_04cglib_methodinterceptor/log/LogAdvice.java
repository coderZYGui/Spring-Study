package com.sunny._04cglib_methodinterceptor.log;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.logging.MemoryHandler;

@SuppressWarnings("all")
// 日志增强
public class LogAdvice implements MethodInterceptor {

    private Object target; // 真实对象
    private LogUtil logUtil; // 日志工具类

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setLogUtil(LogUtil logUtil) {
        this.logUtil = logUtil;
    }

    // 创建代理对象
    public <T> T getProxyObject() {
        /*Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass()); // 将继承于哪一个类,来做增强
        enhancer.setCallback(this); // 设置增强的对象
        return (T) enhancer.create(); // 创建代理对象*/

        return (T) Enhancer.create(target.getClass(), this);
    }


    /**
     * 如何对方法作增强
     * @param proxy     代理对象
     * @param method    要作增强的方法
     * @param objects   要作增强方法的参数
     * @param methodProxy   代理方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        logUtil.writeLog(method.getDeclaringClass().getName(),method.getName());
        Object ret = method.invoke(target, objects); // 调用真实对象的方法
        return ret;
    }
}
