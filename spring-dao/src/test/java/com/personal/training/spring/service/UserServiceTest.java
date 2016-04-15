package com.personal.training.spring.service;

import com.personal.training.spring.application.ApplicationConfig;
import com.personal.training.spring.application.DBConfig;
import com.personal.training.spring.beans.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Nilesh on 4/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBConfig.class, ApplicationConfig.class})
@SqlGroup( {
                @Sql(scripts = "classpath:schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
                @Sql(scripts = "classpath:data.sql"),
                @Sql(scripts = "classpath:delete-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

        }
)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testUser(){
        final User user = userService.getUser(1);

        assertEquals("YASH", user.getName());
        assertEquals("PUNE", user.getCity());
        assertEquals("PUNE", user.getAddress());
        assertEquals("IT", user.getDepartment());
    }


    @Test
    public void testUserList(){
        final List<User> users = userService.getUsers();
        assertEquals(3, users.size());
    }

    @Test
    public void testInsertUsers(){
        List<User> users = IntStream.range(4,15).parallel().boxed().map(id -> getUser(id)).collect(Collectors.toList());
        userService.addUsers(users);
        assertEquals(14, userService.getUsers().size());
    }

    @Test
    public void testDeleteUsers(){
        List<User> users = IntStream.range(4,15).parallel().boxed().map(id -> getUser(id)).collect(Collectors.toList());
        userService.addUsers(users);
        assertEquals(14, userService.getUsers().size());
        final List<Integer> ids = IntStream.range(4, 15).parallel().boxed().collect(Collectors.toList());
        userService.deleteUsers(ids);
        assertEquals(3, userService.getUsers().size());
    }

    private User getUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("Test"+user.getId());
        user.setAddress("Pune");
        user.setCity("Pune");
        return user;
    }

}