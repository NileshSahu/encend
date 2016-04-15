package com.personal.spring.aop.joinpoint;

import org.springframework.stereotype.Component;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Component
public class MySampleJoinPointClass {

    public String getName(){
        System.out.println("returning name ...");
        return "Nilesh";
    }

    public String throwException(){
        throw new RuntimeException("Throwing exception");
    }
}
