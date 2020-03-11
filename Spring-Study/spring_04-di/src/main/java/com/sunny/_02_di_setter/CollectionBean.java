package com.sunny._02_di_setter;

import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Setter
public class CollectionBean {
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
