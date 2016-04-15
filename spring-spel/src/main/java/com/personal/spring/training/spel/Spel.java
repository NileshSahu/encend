package com.personal.spring.training.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Component
@PropertySource(value = "application.properties")
public class Spel {

    @Autowired(required = false)
    List<String> list;

    @Autowired(required = false)
    Map<String, String> map;

    @Value("#{T(java.lang.Math).random()}")
    private Double randomVal;

    @Value("#{systemProperties['spring.profiles.active']?:'Default Profile'}")
    private String profile;

    @Value("#{systemProperties['testProperty']!=null?systemProperties['testProperty']:environment['spring.profiles.active']}")
    private String propertyValue;

    @Value("#{@map['key']}")
    private String mapKeyValue;

    @Value("#{list[0]}")
    private String firstElement;

    public String getFirstElement() {
        return firstElement;
    }

    public List<String> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Double getRandomVal() {
        return randomVal;
    }

    public String getProfile() {
        return profile;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public String getMapKeyValue() {
        return mapKeyValue;
    }
}
