package com.personal.spring.core.conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Nilesh on 3/20/2016.
 */
public class ProfileBasedAppContextTest {

    public static void main(String[] args) {
        //System.setProperty("spring.profiles.active","");
        System.setProperty("spring.profiles.active","profile");
        System.setProperty("role","developer");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConditionalBean.class);
        System.out.println("Total beans = "+context.getBeanDefinitionCount()+":"+Arrays.asList(context.getBeanDefinitionNames()));

    }
}
