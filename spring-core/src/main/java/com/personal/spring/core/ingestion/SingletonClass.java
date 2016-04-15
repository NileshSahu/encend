package com.personal.spring.core.ingestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Component
public class SingletonClass {


    @Autowired
    PrototypeClass prototypeClass;

    private double count = Math.random();

    public double getSingletonCount(){
        return count;
    }

    public double getPrototypeCount(){
        return prototypeClass.getCount();
    }
}
