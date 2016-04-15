package com.personal.spring.core.dto;

/**
 * Created by Nilesh on 3/19/2016.
 */
public class HelloWorld {

    private String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    public String getName() {
        return "Hello : "+ name;
    }
}
