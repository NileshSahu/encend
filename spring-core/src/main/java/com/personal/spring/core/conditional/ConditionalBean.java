package com.personal.spring.core.conditional;

import com.personal.spring.core.dto.Developer;
import com.personal.spring.core.dto.Manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * Created by Nilesh on 3/20/2016.
 */
public class ConditionalBean extends ProfileBasedApplicationContext {

    @Bean
    @Conditional(ManagerCondition.class)
    public Manager manager(){
        System.out.println("Creating manager bean");
        return new Manager(2, "manager");
    }

    @Bean
    @Conditional(DeveloperCondition.class)
    public Developer developer(){
        System.out.println("Creating developer bean");
        return new Developer(3, "dev");
    }

}
