package com.personal.spring.boot.mvc.controller;

import com.personal.spring.boot.dto.User;
import com.personal.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nilesh on 3/26/2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/form/add")
    public ModelAndView addUser(@RequestParam String name, @RequestParam String address, @RequestParam String contactNum, @RequestParam String role, @RequestParam String department) {
        User user = new User();
        Random random = new Random();
        user.setId(random.nextInt() % 1000);
        user.setName(name);
        user.setAddress(address);
        user.setDepartment(department);
        final User savedUser = userService.saveOrUpdate(user);
        List<User> employeeList = new ArrayList<User>();
        employeeList.add(user);
        ModelAndView modelAndView = new ModelAndView("employeeRecord", "employee", employeeList);
        return modelAndView;
    }

    @RequestMapping(path = "/form/update")
    public ModelAndView updateUser(@RequestParam Integer id, @RequestParam String name, @RequestParam String address, @RequestParam String contactNum, @RequestParam String role, @RequestParam String department) {
        User employee = new User();
        employee.setId(id);
        employee.setName(name);
        employee.setAddress(address);
        employee.setDepartment(department);

        final User savedUser = userService.saveOrUpdate(employee);
        List<User> employeeList = new ArrayList<User>();
        employeeList.add(savedUser);
        ModelAndView modelAndView = new ModelAndView("employeeRecord", "employee", employeeList);
        return modelAndView;
    }

    @RequestMapping(path = "/form/details")
    public ModelAndView getUser(@RequestParam Integer id) {
        final User user = userService.getUserById(id);
        List<User> employeeList = new ArrayList<User>();
        employeeList.add(user);
        ModelAndView modelAndView = new ModelAndView("employeeRecord", "employee", employeeList);
        return modelAndView;
    }

    @RequestMapping(path = "/form/list", method = RequestMethod.GET)
    public ModelAndView getUserList() {
        List<User> employeeList = userService.getUserList();
        ModelAndView modelAndView = new ModelAndView("employeeRecord", "employee", employeeList);
        System.out.println("Returning  " + modelAndView.getViewName() + " ::  " + modelAndView.getModelMap());
        return modelAndView;
    }

    @RequestMapping(path = "/form/delete")
    public ModelAndView deleteUser(@RequestParam Integer id) {
        userService.delete(id);
        ModelAndView modelAndView = new ModelAndView("success", "message", "User record deleted successfully. " + id);
        return modelAndView;
    }

}
