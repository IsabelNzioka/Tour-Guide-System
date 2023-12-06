package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.MysqlDatabaseTodelete;
import com.systechafrica.app.utility.HashText;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class UserBean extends GenericBean<User> implements UserBeanI {
    @PersistenceContext
    EntityManager em;

    @Inject
    private HashText hashText;

    @Override
    public User register(User user) throws SQLException {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new RuntimeException("Password & confirm password do not match");
        }
        // Check if the user already exists
        if (isUserExists(user.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        try {
            user.setPassword(hashText.hash(user.getPassword()));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        User userR = new User();
        getDao().addOrUpdateEntity(user); //save data to the database

        //        login user
//        try (PreparedStatement sqlStmt = database.getConnection()
//                .prepareStatement("SELECT * FROM users WHERE username = ?")) {
//            sqlStmt.setString(1, user.getUsername());
//            ResultSet result = sqlStmt.executeQuery();
//            while (result.next()) {
//                userR.setUsername(result.getString("username"));
//                userR.setEmail(result.getString("email"));
//            }
//        }

        return userR;
    }


    @Override
    public boolean isUserExists(String email) throws SQLException {

            return false; // true if email is already taken
        }

    @Override
    public List<User> list(User user) {
       return em.createQuery("FROM User u").getResultList();
    }
}




