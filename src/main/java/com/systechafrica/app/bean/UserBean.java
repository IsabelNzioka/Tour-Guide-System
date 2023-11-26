package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;
import com.systechafrica.database.MysqlDatabase;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserBean extends GenericBean<User> implements UserBeanI {







    @Override
    public User register(User user)  throws SQLException {
        User userR = new User();

        System.out.println("Password: " + user.getPassword());
        System.out.println("Confirm Password: " + user.getConfirmPassword());


        if (user.getPassword().equals(user.getConfirmPassword())) {

//  TODO  - check if user exxists - email
//            hash passwords
//            initiate events to send email  -- Observer design pattern
//
            MysqlDatabase.saveOrUpdate(user);


            // Login User
            try(PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
                    .prepareStatement("SELECT * FROM users WHERE username = ?")) {

                sqlStmt.setString(1, user.getUsername());
                ResultSet result = sqlStmt.executeQuery();
                while (result.next()) {
                    userR.setUsername(result.getString("username"));
                    userR.setEmail(result.getString("email"));
                }

            }

        } else {
            return null;
        }
        return userR;

    }





    }

