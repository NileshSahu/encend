package com.personal.spring.boot.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Nilesh on 3/26/2016.
 */
@XmlRootElement
public class Employees {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
