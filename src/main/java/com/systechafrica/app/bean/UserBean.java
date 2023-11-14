package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;

import java.io.Serializable;

public class UserBean implements  UserBeanI, Serializable {
    Database database = Database.getDbInstance();


    @Override
    public User register(User user) {

        User registeredUser  = null;

        if (user.getPassword().equals(user.getConfirmPassword())) {
            database.getUsers().add(new User(100L, user.getUsername(), user.getPassword())); // add the user to the database
            registeredUser = user;
        }
        return registeredUser;

        }

    @Override
    public boolean unregister(User user) {
            return true;
        }

    }

