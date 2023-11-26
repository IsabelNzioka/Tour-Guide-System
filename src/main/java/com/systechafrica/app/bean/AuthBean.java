package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;
import com.systechafrica.database.MysqlDatabase;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Stateless
public class AuthBean  implements AuthBeanI, Serializable {
    @EJB
    MysqlDatabase database;


    public User authenticate(User loginUser) throws SQLException{

//        List<User> users = database.select(loginUser);
//
//        if (users.isEmpty() || users.get(0) == null)
//            throw new RuntimeException("Invalid user!!");
//
//        return users.get(0);

        PreparedStatement sqlStmt = database.getConnection().prepareStatement("select id,username from users where username=? and password=? limit 1");
        sqlStmt.setString(1, loginUser.getUsername());
        sqlStmt.setString(2, loginUser.getPassword());

        ResultSet result = sqlStmt.executeQuery();

        User user = null;
        while (result.next()){
            user = new User();
            user.setId(result.getLong("id"));
            user.setUsername(result.getString("username"));

        }
        return user;
    }

}
