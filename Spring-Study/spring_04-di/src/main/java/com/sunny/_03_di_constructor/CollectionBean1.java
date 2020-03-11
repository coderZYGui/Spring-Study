package com.sunny._03_di_constructor;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor //生成全参数构造器

public class CollectionBean1 {
    private Set<String> set;
    private List<String> list;
    private String[] array;
    private Map<String, String> map;
    private Properties prop;

    @Override
    public String toString() {
        return "CollectionBean{" +
                "\nset=" + set +
                ", \nlist=" + list +
                ", \narray=" + Arrays.toString(array) +
                ", \nmap=" + map +
                ", \nprop=" + prop +
                '}';
    }
}
