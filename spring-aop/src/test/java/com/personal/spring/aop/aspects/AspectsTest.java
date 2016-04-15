package com.personal.spring.aop.aspects;

import com.personal.spring.aop.joinpoint.MySampleJoinPointClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by Nilesh on 4/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class AspectsTest {

    @Configuration
    @EnableAspectJAutoProxy
    static class Config{
        @Bean
        public Aspects aspects(){
            return new Aspects();
        }

        @Bean
        public MySampleJoinPointClass mySampleJoinPointClass(){
            return new MySampleJoinPointClass();
        }
    }

    @Autowired
    MySampleJoinPointClass sampleJoinPointClass;

    @Autowired
    Aspects aspects;

    @Test
    public void test(){
        sampleJoinPointClass.getName();
    }

}
