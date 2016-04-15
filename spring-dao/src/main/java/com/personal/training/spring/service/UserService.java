package com.personal.training.spring.service;

import com.personal.training.spring.beans.User;
import com.personal.training.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, timeout = 100)
    public User getUser(Integer id){
        return userDao.getUserById(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, timeout = 100)
    public List<User> getUsers(){
        return userDao.getAllUsers();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 100)
    public int[] addUsers(List<User> users){
        return userDao.addUsers(users);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 100)
    public int[] updateUsers(List<User> users){
        return userDao.updateUsers(users);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 100)
    public int[] deleteUsers(List<Integer> userIds){
        return userDao.deleteUsers(userIds);
    }

}
