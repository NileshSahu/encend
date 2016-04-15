package com.personal.spring.core.dto;

/**
 * Created by Nilesh on 3/19/2016.
 */
public class Employee extends  Person{

    private int id;
    private String name;
    private String role;

    public Employee(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
