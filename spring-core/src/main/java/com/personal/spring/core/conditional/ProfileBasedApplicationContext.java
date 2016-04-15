package com.personal.spring.core.conditional;

import com.personal.spring.core.dto.Employee;
import com.personal.spring.core.dto.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Nilesh on 3/20/2016.
 */
@Configuration
@PropertySource("classpath:application.properties")
@Profile("profile")
public class ProfileBasedApplicationContext {

    @Bean
    public Employee employee(){
        Employee employee = new Employee(1, "Yash");
        employee.setRole("CEO");
        return employee;
    }

    @Bean
    public Person person(){
        return new Person(1);
    }
}
