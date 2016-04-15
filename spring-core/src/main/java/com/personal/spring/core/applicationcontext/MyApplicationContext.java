package com.personal.spring.core.applicationcontext;

import com.personal.spring.core.lifecycle.BeanLifeCycle;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nilesh on 3/19/2016.
 */

public class MyApplicationContext {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        String[] names = context.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
        /*Employee employee = context.getBean("employee",Employee.class);
        System.out.println(employee.getName());
        System.out.println(employee.getRole());
        System.out.println(employee.getId());

        employee.setName("nilesh");

        Employee employee1 = context.getBean("employee",Employee.class);
        System.out.println(employee1.getName());
        System.out.println(employee1.getRole());
        System.out.println(employee1.getId());


        String[] definitionNames = context.getBeanDefinitionNames();
        for (String defName: definitionNames ) {
            System.out.println(defName);
        }
*/
    }
}
