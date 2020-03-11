package com.sunny.domain2;

import lombok.Data;

@Data
public class HelloGui {
    private String username;
    private String password;

    public void doWork(){
        System.out.println("执行dowork!!");
    }
}
