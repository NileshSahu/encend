package com.personal.spring.training.spel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Configuration
@ComponentScan(basePackages = "com.personal.spring.training")
public class SpelConfig {

    @Bean
    public List<String> list() {
        List<String> list = new ArrayList<String>();
        list.add("Element-1");
        list.add("Elememt-2");
        return list;
    }

    @Bean
    public Map<String, String> map() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "Value");
        map.put("key", "Value");
        return map;
    }

    @Bean
    public Spel spel(){
        return new Spel();
    }

}
