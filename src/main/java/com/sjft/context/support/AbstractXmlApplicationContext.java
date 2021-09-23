package com.sjft.context.support;

import com.sjft.beans.factory.support.DefaultListableBeanFactory;
import com.sjft.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author Sjft
 * @date 2021/09/16 19:35
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
