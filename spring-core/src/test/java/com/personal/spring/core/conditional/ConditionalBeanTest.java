package com.personal.spring.core.conditional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nilesh on 4/3/2016.
 */
@ContextConfiguration(locations = "/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConditionalBeanTest {

    @Autowired
    private ApplicationContext context;

    @Before
    public void checkProfile() {
        SystemProfileValueSource src = SystemProfileValueSource.getInstance();
        System.setProperty("spring.profiles.active", "developer");
        System.out.println(src.get("spring.profiles.active"));
    }

    /* Test only if profile set */
    @Test
    public void testConditionalBeanDeveloperCreated(){
        final List<Boolean> list = checkDefinitionNames();
        assertTrue(list.get(0));
        assertFalse(list.get(1));
    }

    @Test
    public void testConditionalBeansNotCreated() {
        System.setProperty("spring.profiles.active", "profileTest");
        SystemProfileValueSource src = SystemProfileValueSource.getInstance();
        System.out.println(src.get("spring.profiles.active"));
        final List<Boolean> list = checkDefinitionNames();
        assertFalse(list.get(0));
        assertFalse(list.get(1));
    }

    public List<Boolean> checkDefinitionNames() {
        List<Boolean> list = new ArrayList<Boolean>();
        final String[] beanDefinitionNames = context.getBeanDefinitionNames();
        boolean isDeveloperBeanCreated = false;
        boolean isManagerBeanCreated = false;
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
            if (beanDefinitionName.equals("developer") && !isDeveloperBeanCreated) {
                isDeveloperBeanCreated = true;

            }
            if (beanDefinitionName.equals("manager") && !isManagerBeanCreated) {
                isManagerBeanCreated = true;
            }
        }
        list.add(isDeveloperBeanCreated);
        list.add(isManagerBeanCreated);
        return list;
    }
}

