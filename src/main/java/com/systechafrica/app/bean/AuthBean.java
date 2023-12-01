package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.MysqlDatabase;
import com.systechafrica.app.utility.HashText;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class AuthBean  implements AuthBeanI, Serializable {
    @EJB
    MysqlDatabase database;

    @Inject
    private HashText hashText;


    public User authenticate(User loginUser) throws SQLException{

        try {
            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

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
