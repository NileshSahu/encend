package com.personal.spring.boot.dao;

import com.personal.spring.boot.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nilesh on 3/26/2016.
 */
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
}
