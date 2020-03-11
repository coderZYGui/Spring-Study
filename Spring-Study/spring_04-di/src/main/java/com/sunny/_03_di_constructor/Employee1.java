package com.sunny._03_di_constructor;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public class Employee1 {
    private String name;
    private Integer age;
    private BigDecimal salary;
}