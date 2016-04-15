package com.personal.spring.core.ingestion;

import com.personal.spring.core.configuration.AnnotatedApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Nilesh on 4/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotatedApplicationContext.class)
public class SingletonClassTest {

    @Autowired
    SingletonClass singleton;

    @Test
    public void testGetSingletonCount() throws Exception {

        final double singletonCount = singleton.getSingletonCount();
        final double singletonCount2 = singleton.getSingletonCount();

        final double prototypeCount = singleton.getPrototypeCount();
        final double prototypeCount2 = singleton.getPrototypeCount();

        System.out.println(""+singletonCount+" : "+singletonCount2);
        assertEquals(new Double(singletonCount), new Double(singletonCount2));
        assertNotEquals(new Double(prototypeCount), new Double(prototypeCount2));

    }
}