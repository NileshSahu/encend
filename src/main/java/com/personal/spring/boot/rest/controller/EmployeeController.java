package com.personal.spring.boot.rest.controller;

import com.personal.spring.boot.dto.Employee;
import com.personal.spring.boot.dto.Employees;
import com.personal.spring.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by Nilesh on 3/26/2016.
 */
@RestController("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/add", method= RequestMethod.PUT)
    public Employee addEmployee(@RequestParam String name, @RequestParam String address, @RequestParam String contactNum, @RequestParam String role, @RequestParam String department){
        Employee employee = new Employee();
        Random random = new Random();
        employee.setId(random.nextLong()%1000);
        employee.setName(name);
        employee.setAddress(address);
        employee.setContactNum(contactNum);
        employee.setDepartment(department);
        employee.setRole(role);
        return employeeService.saveOrUpdate(employee);
    }

    @RequestMapping(path = "/update", method= RequestMethod.POST)
    public Employee updateEmployee(@RequestParam Long id,@RequestParam String name, @RequestParam String address, @RequestParam String contactNum, @RequestParam String role, @RequestParam String department){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAddress(address);
        employee.setContactNum(contactNum);
        employee.setDepartment(department);
        employee.setRole(role);

        return employeeService.saveOrUpdate(employee);
    }

    @RequestMapping(path = "/details/{Id}", method= RequestMethod.GET)
    public Employee getEmployee(@PathVariable(value = "Id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(path = "/list", method= RequestMethod.GET)
    public Employees getEmployeeList(){
        Employees employees = new Employees();
        employees.setEmployees(employeeService.getEmployeeList());
        return employees;
    }

    @RequestMapping(path = "/delete/{Id}", method= RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable(value = "Id") Long id){
        employeeService.delete(id);
        return "Employee record deleted successfully.";
    }

}
