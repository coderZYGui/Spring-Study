package com.sunny._02_di_setter;

import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@ToString
public class Employee {
    private String name;
    private Integer age;
    private BigDecimal salary;
}
