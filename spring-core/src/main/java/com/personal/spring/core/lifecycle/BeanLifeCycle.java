package com.personal.spring.core.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by Nilesh on 3/20/2016.
 */
@Component
public class BeanLifeCycle implements BeanNameAware,ApplicationContextAware, BeanClassLoaderAware, BeanFactoryAware, BeanPostProcessor, BeanFactoryPostProcessor, InitializingBean, DisposableBean {

    private static final Logger logger = Logger.getLogger(BeanLifeCycle.class.getName());
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Set Application Context "+ applicationContext);
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("Set BeanClassLoader "+ classLoader);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("Set BeanFactory "+ beanFactory);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        logger.info("BeanFactory PostProcessor  "+ configurableListableBeanFactory);
    }

    public void setBeanName(String beanName) {
        logger.info("Set BeanName -> "+beanName);
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.info("Post Process bean before initializing "+s+" : "+o);
        return o;

    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("Post Process bean after initializing "+s+" : "+o);
        return o;
    }

    public void destroy() throws Exception {
        logger.info("Destoring bean ");
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("Initialize values after property set");
    }
}
