package com.sjft.beans.factory.config;

import com.sjft.beans.PropertyValues;

/**
 * 属性值
 * @author Sjft
 * @date 2021/7/28
 **/
public class BeanDefinition {

    private Class beanClass;

    /**
     * bean 属性
     *  1. 基础属性(int, String)
     *  2. 对象属性、引用类型(BeanReference)
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
