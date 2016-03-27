package com.personal.spring.boot.service;

import com.personal.spring.boot.dao.EmployeeDAO;
import com.personal.spring.boot.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Created by Nilesh on 3/26/2016.
 */
@Service
@Validated
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee saveOrUpdate(Employee employee){
        final Employee savedEmp = employeeDAO.save(employee);
        return savedEmp;
    }

    public void delete(Long id){
        employeeDAO.delete(id);
    }

    public Employee getEmployeeById(long id){
        final Employee employee = employeeDAO.findOne(id);
        return employee;
    }

    public List<Employee> getEmployeeList(){
        List<Employee> employees = employeeDAO.findAll();
        return employees;
    }

}
