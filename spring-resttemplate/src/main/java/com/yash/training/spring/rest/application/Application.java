package com.yash.training.spring.rest.application;

import com.yash.training.spring.rest.template.RestTemplateExample;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;

/**
 * Created by Nilesh on 4/15/2016.
 */
public class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final RestTemplateExample templateExample = context.getBean(RestTemplateExample.class);
        System.out.println(templateExample.getResponse());
        System.out.println(templateExample.getAsyncResponse());

    }
}
