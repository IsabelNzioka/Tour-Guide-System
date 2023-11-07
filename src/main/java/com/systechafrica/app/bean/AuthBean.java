package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;

public class AuthBean  implements AuthBeanI, Serializable {
    Database database = Database.getDbInstance();
    public User authenticate(User loginUser) {
        User userDetails = null;

        for(User user : database.getUsers()) {
            if (loginUser.getUsername().equals(user.getUsername() ) && loginUser.getPassword().equals(user.getPassword())) {
            userDetails  = user;

            break;
            }
        }
        return userDetails;

    }
}
