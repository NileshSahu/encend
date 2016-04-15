package com.personal.spring.core.applicationcontext;

import com.personal.spring.core.configuration.AnnotatedApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Nilesh on 3/19/2016.
 */
public class MyAnnotatedApplicationContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotatedApplicationContext.class);
        System.out.println(context.getBean("emp-alias"));

/*
        Employee employee = context.getBean(Employee.class);
        System.out.println(employee.getName());
        System.out.println(employee.getRole());
        System.out.println(employee.getId());

        employee.setName("nilesh");

        Employee employee1 = context.getBean(Employee.class);
        System.out.println(employee1.getName());
        System.out.println(employee1.getRole());
        System.out.println(employee1.getId());
*/
/*

        String[] definitionNames = context.getBeanDefinitionNames();
        for (String defName: definitionNames ) {
            System.out.println(defName);
        }


*/
    }
}
