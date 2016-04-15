package com.personal.spring.core.configuration;

import com.personal.spring.core.dto.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

/**
 * Created by Nilesh on 3/19/2016.
 */
@Configuration
@ComponentScan(basePackages = "com.personal.spring.core", lazyInit = true)
public class AnnotatedApplicationContext {

    @Bean
    @AliasFor("emp-alias")
    public Employee getEmployee(){
        Employee emp =  new Employee(1, "Nilesh");
        emp.setRole("Employee :)");
        return emp;
    }
}
