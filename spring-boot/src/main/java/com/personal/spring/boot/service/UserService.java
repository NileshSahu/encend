package com.personal.spring.boot.service;

import com.personal.spring.boot.dao.UserDAO;
import com.personal.spring.boot.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Created by Nilesh on 3/26/2016.
 */
@Service
@Validated
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User saveOrUpdate(User user){
       final User savedUser = userDAO.save(user);
        return savedUser;
    }

    public void delete(Integer id){
        userDAO.delete(id);
    }

    public User getUserById(Integer id){
        final User user = userDAO.findOne(id);
        return user;
    }

    public List<User> getUserList(){
        List<User> user = userDAO.findAll();
        return user;
    }

}
