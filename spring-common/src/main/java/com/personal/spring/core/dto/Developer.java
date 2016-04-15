package com.personal.spring.core.dto;

/**
 * Created by Nilesh on 3/19/2016.
 */
public class Developer extends  Employee {

    private String role;

    public Developer(int id, String name) {
        super(id, name);
        this.setRole("Developer");
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
