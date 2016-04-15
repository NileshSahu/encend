package com.personal.spring.boot.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Nilesh on 4/15/2016.
 */
@XmlRootElement
public class UserList {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
