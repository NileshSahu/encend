package com.personal.spring.aop.joinpoint.inner;

import org.springframework.stereotype.Component;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Component
public class InnerJoinPoint{

    public String getName(){
        return "InnerJoinPoint";
    }
}
