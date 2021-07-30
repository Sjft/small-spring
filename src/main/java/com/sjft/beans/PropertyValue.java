package com.sjft.beans;

/**
 * @author Sjft
 * @date 2021/07/28 17:43
 **/
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
