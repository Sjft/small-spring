package com.sjft.beans.factory.support;

import com.sjft.beans.BeansException;
import com.sjft.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author Sjft
 * @date 2021/07/28 14:11
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // todo 给 bean 填充属性


        } catch (Exception e) {
            throw new BeansException("instantiation of bean failed", e);
        }
        // bean 对象实例化后, 存放到单例对象的缓存中
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            // todo 比对构造函数集合与入参args的匹配情况，还需比对入参类型
            if (args != null && ctor.getGenericParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
