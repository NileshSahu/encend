package com.personal.spring.boot.mvc.controller;

import com.personal.spring.boot.dto.Employee;
import com.personal.spring.boot.service.EmployeeService;
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
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/form/add")
    public ModelAndView addEmployee(@RequestParam String name, @RequestParam String address, @RequestParam String contactNum, @RequestParam String role, @RequestParam String department){
        Employee employee = new Employee();
        Random random = new Random();
        employee.setId(random.nextLong()%1000);
        employee.setName(name);
        employee.setAddress(address);
        employee.setContactNum(contactNum);
        employee.setDepartment(department);
        employee.setRole(role);
        final Employee emp = employeeService.saveOrUpdate(employee);
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp);
        ModelAndView modelAndView = new ModelAndView("employeeRecord","employee",employeeList);
        return modelAndView;
    }

    @RequestMapping(path = "/form/update")
    public ModelAndView updateEmployee(@RequestParam Long id,@RequestParam String name, @RequestParam String address, @RequestParam String contactNum, @RequestParam String role, @RequestParam String department){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAddress(address);
        employee.setContactNum(contactNum);
        employee.setDepartment(department);
        employee.setRole(role);

        final Employee emp = employeeService.saveOrUpdate(employee);
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp);
        ModelAndView modelAndView = new ModelAndView("employeeRecord","employee",employeeList);
        return modelAndView;
    }

    @RequestMapping(path = "/form/details")
    public ModelAndView getEmployee(@RequestParam Long id){
        final Employee emp = employeeService.getEmployeeById(id);
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp);
        ModelAndView modelAndView = new ModelAndView("employeeRecord","employee",employeeList);
        return modelAndView;
    }

    @RequestMapping(path = "/form/list", method= RequestMethod.GET)
    public ModelAndView getEmployeeList(){
        List<Employee> employeeList = employeeService.getEmployeeList();
        ModelAndView modelAndView = new ModelAndView("employeeRecord","employee",employeeList);
        System.out.println("Returning  "+modelAndView.getViewName()+" ::  "+modelAndView.getModelMap());
        return modelAndView;
    }

    @RequestMapping(path = "/form/delete")
    public ModelAndView deleteEmployee(@RequestParam Long id){
        employeeService.delete(id);
        ModelAndView modelAndView = new ModelAndView("success","message","Employee record deleted successfully. "+id);
        return modelAndView;
    }

}
