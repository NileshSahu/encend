package com.personal.spring.core.ingestion;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Component
@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
public class PrototypeClass {

    private double count = Math.random();

    public double getCount() {
        return count;
    }

}
