package com.sjft.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.sjft.beans.BeansException;
import com.sjft.beans.PropertyValue;
import com.sjft.beans.factory.config.BeanDefinition;
import com.sjft.beans.factory.config.BeanReference;
import com.sjft.beans.factory.support.AbstractBeanDefinitionReader;
import com.sjft.beans.factory.support.BeanDefinitionRegistry;
import com.sjft.core.io.Resource;
import com.sjft.core.io.ResourceLoader;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sift
 * @date 2021-07-31 18:21
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new BeansException("IOException parsing XML document from" + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        final ResourceLoader resourceLoader = getResourceLoader();
        final Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        final Document document = XmlUtil.readXML(inputStream);
        final Element root = document.getDocumentElement();
        final NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断元素
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }

            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            // 解析标签
            final Element bean = (Element) childNodes.item(i);
            final String id = bean.getAttribute("id");
            final String name = bean.getAttribute("name");
            final String className = bean.getAttribute("class");

            // 获取 class, 方便获取类名
            final Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StringUtils.isNotBlank(id) ? id : name;
            if (StringUtils.isBlank(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义 bean
            final BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // 读取并填充属性
            NodeList elementNodes = bean.getChildNodes();
            for (int j = 0; j < elementNodes.getLength(); j++) {
                if (!(elementNodes.item(j) instanceof Element)) {
                    continue;
                }

                if (!"property".equals(elementNodes.item(j).getNodeName())) {
                    continue;
                }

                // 解析 property 标签
                final Element property = (Element) elementNodes.item(j);
                final String attrName = property.getAttribute("name");
                final String attrValue = property.getAttribute("value");
                final String attrRef = property.getAttribute("ref");
                // 获取属性值：值对象、引入对象
                Object value = StringUtils.isNotBlank(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                final PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            if (getRegister().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegister().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
