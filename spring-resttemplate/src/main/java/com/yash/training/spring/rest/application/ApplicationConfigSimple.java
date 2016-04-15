package com.yash.training.spring.rest.application;

import com.yash.training.spring.rest.template.RestTemplateExample;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

/**
 * Created by Nilesh on 4/15/2016.
 */
public class ApplicationConfigSimple {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public AsyncRestTemplate asynchrestTemplate(){
        return new AsyncRestTemplate(new HttpComponentsAsyncClientHttpRequestFactory(), restTemplate());
    }

    @Bean
    public RestTemplateExample restTemplateExample(){
        RestTemplateExample example = new RestTemplateExample();
        example.setRestTemplate(restTemplate());
        example.setAsyncRestTemplate(asynchrestTemplate());
        return  example;
    }

    public Callable<String> implem(){
        return () -> {//test expression
            return  "hello" ;
        };
    }

}
