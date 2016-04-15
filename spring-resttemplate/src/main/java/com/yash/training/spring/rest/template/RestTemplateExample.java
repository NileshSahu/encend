package com.yash.training.spring.rest.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Component
public class RestTemplateExample {

    RestTemplate restTemplate;

    AsyncRestTemplate asyncRestTemplate;

    public String getResponse(){
        final String response = restTemplate.getForObject("https://www.google.com", String.class);
        return response;
    }

    public String getAsyncResponse() throws ExecutionException, InterruptedException {
        System.out.println("Request got at "+new Date());
        final ListenableFuture<ResponseEntity<String>> entity = asyncRestTemplate.getForEntity("https://www.google.com", String.class);
        System.out.println("Future got at "+new Date());
        final ResponseEntity<String> stringResponseEntity = entity.get();
        System.out.println("Response got at "+new Date());
        return stringResponseEntity.getBody();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setAsyncRestTemplate(AsyncRestTemplate asyncRestTemplate) {
        this.asyncRestTemplate = asyncRestTemplate;
    }
}
