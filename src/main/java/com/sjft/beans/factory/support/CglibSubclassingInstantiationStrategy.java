package com.sjft.beans.factory.support;

import com.sjft.beans.BeansException;
import com.sjft.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author Sjft
 * @date 2021/07/28 15:55
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (ctor != null) {
            return enhancer.create(ctor.getParameterTypes(), args);
        }

        return enhancer.create();
    }
}
