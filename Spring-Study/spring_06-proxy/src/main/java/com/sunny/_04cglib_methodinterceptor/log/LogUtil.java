package com.sunny._04cglib_methodinterceptor.log;

import java.util.Date;

// 在service方法调用之前,做日志记录
public class LogUtil {

    public void writeLog(String methodClass,String methodName){
        System.out.println(new Date().toLocaleString() + "调用了"+methodClass+"类中的" +methodName + "方法");
    }
}
