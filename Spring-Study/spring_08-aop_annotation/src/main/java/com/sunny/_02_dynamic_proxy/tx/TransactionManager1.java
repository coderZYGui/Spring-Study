package com.sunny._02_dynamic_proxy.tx;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component // IoC注解
@Aspect // 配置一个切面
public class TransactionManager1 {

    // 配置在哪些包中的哪些类中的哪些方法上做增强
    //XML: <aop:pointcut id="txPoint"expression="execution(* com.sunny.aop_annotation.service.*Service1.*(..))"/>
    @Pointcut("execution(* com.sunny._02_dynamic_proxy.service.*Service1.*(..))")
    public void txPoint(){

    }

    @Before("txPoint()")
    public void begin(JoinPoint jp){
        System.out.println("开启事务");
    }

    @AfterReturning("txPoint()") // 操作完成之后
    public void commit(){
        System.out.println("提交事务");
    }

    @AfterThrowing(value = "txPoint()", throwing = "exception")
    public void rollback(Throwable exception){
        System.out.println("回滚事务: " + "异常信息:" + exception);
    }

    @After("txPoint()")
    public void close(){
        System.out.println("释放资源");
    }

    //@Around("txPoint()") // 可以替代上面的几个注解
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
