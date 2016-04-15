package com.personal.spring.aop.aspects;

import com.personal.spring.aop.joinpoint.MySampleJoinPointClass;
import com.personal.spring.aop.joinpoint.inner.InnerJoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Nilesh on 4/15/2016.
 */
public class Test {
        public static void main(String[] args){
            ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfiguration.class);
            final MySampleJoinPointClass mySampleJoinPointClass = context.getBean(MySampleJoinPointClass.class);
            final InnerJoinPoint bean = context.getBean(InnerJoinPoint.class);

            mySampleJoinPointClass.getName();
            bean.getName();
            mySampleJoinPointClass.throwException();

    }
}
