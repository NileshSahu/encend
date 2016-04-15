package com.personal.spring.training.spel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Nilesh on 4/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpelConfig.class)
@TestPropertySource(properties = {"spring.profiles.active=Devil"})
public class SpelTest {

    @Autowired
    private Spel spel;

    @BeforeClass
    public static void setUp(){
        System.setProperty("testProperty","test");
    }

    @Test
    public void testSpelProperties(){
        assertEquals("Element-1", spel.getFirstElement());
        assertEquals("Value", spel.getMapKeyValue());
        assertNotNull(spel.getRandomVal());
        assertEquals("Default Profile", spel.getProfile());
        assertEquals("test", spel.getPropertyValue());

    }
}