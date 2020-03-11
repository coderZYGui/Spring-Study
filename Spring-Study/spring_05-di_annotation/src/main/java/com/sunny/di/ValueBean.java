package com.sunny.di;

import org.springframework.beans.factory.annotation.Value;

public class ValueBean {
    //@Value("9999")
    @Value("${server.port}")
    private int port;

    @Override
    public String toString() {
        return "ValueBean{" +
                "port=" + port +
                '}';
    }
}
