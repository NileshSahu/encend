package com.personal.spring.boot.rest.controller;

import com.personal.spring.boot.dto.User;
import com.personal.spring.boot.dto.UserList;
import com.personal.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by Nilesh on 3/26/2016.
 */
@RestController("/api/employee")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/add", method= RequestMethod.PUT)
    public User addUser(User userIn){
        User user = new User();
        user.setId(userIn.getId());
        user.setName(userIn.getName());
        user.setAddress(userIn.getAddress());
        user.setDepartment(userIn.getDepartment());
        user.setCity(userIn.getCity());
        return userService.saveOrUpdate(user);
    }

    @RequestMapping(path = "/update", method= RequestMethod.POST)
    public User updateUser(@RequestParam Integer id,@RequestParam String name, @RequestParam String address, @RequestParam String city, @RequestParam String department){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        user.setDepartment(department);
        user.setCity(city);
        return userService.saveOrUpdate(user);
    }

    @RequestMapping(path = "/details/{Id}", method= RequestMethod.GET)
    public User getUser(@PathVariable(value = "Id") Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/list", method= RequestMethod.GET)
    public UserList getUserList(){
        UserList users = new UserList();
        users.setUsers(userService.getUserList());
        return users;
    }

    @RequestMapping(path = "/delete/{Id}", method= RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value = "Id") Integer id){
        userService.delete(id);
        return "User record deleted successfully.";
    }

}
