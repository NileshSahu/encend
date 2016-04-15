package com.personal.spring.aop.aspects;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Configuration
@ComponentScan(basePackages = "com.personal.spring")
@EnableAspectJAutoProxy
public class AOPConfiguration{
}
