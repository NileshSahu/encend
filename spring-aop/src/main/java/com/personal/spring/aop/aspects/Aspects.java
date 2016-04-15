package com.personal.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Component
@Aspect
public class Aspects {

    @Before("execution(* com.personal.spring.aop.joinpoint..*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("***AspectJ*** before() is running!! intercepted : " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.personal.spring.aop.joinpoint..*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("***AspectJ*** after() is running!! intercepted : " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.personal.spring.aop.joinpoint..*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("***AspectJ*** around() is running!! intercepted : " + joinPoint.getSignature().getName());
        long nanos = System.currentTimeMillis();
        joinPoint.proceed();
        System.out.println("Total time in execution "+(System.currentTimeMillis()-nanos)+"ms.");
    }

    @AfterReturning(pointcut = "execution(* com.personal.spring.aop.joinpoint..*(..))", returning= "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("***AspectJ*** afterReturning() is running!! intercepted : " + joinPoint.getSignature().getName()+" with result "+result);
        System.out.println("Method returned value is : " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.personal.spring.aop.joinpoint..*(..))", throwing= "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("***AspectJ*** afterThrowing() is running!! intercepted : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");
    }
}
