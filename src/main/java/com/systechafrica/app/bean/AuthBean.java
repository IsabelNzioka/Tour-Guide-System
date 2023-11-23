package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;
import com.systechafrica.database.MysqlDatabase;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class AuthBean  implements AuthBeanI, Serializable {
    Database database = Database.getDbInstance();


    public User authenticate(User loginUser) throws SQLException {
        PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
        .prepareStatement("select id,username from users where username=? and password=? limit 1");
        sqlStmt.setString(1, loginUser.getUsername());
        sqlStmt.setString(2, loginUser.getPassword());

        ResultSet result = sqlStmt.executeQuery();

        User user = null;
        while (result.next()){
            user = new User();
            user.setId(result.getLong("id"));
            user.setUsername(result.getString("username"));
            // user.setRole(result.getString("role"));
        }

        return user;
    }


    

     @Override
     public User register(User user)  throws SQLException{
        User userR = new User();

        System.out.println("Password: " + user.getPassword());
        System.out.println("Confirm Password: " + user.getConfirmPassword());


        if (user.getPassword().equals(user.getConfirmPassword())) {
                MysqlDatabase.saveOrUpdate(user);

//            TODO = GENERIC

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
