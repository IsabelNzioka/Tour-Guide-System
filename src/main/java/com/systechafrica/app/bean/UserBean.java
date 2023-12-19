package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.utility.HashText;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class UserBean extends GenericBean<User> implements UserBeanI {
    @PersistenceContext
    EntityManager em;

    @Inject
    private HashText hashText;

    @Override
    public User register(User user) {
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
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + user);
//        User userR = new User();
        getDao().addOrUpdateEntity(user); //save data to the database

        return user;
    }

    @Override
    public User changePassword(User user) throws SQLException {
        return null;
    }

    @Override
    public boolean isUserExists(String email) {
                String jpql = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("email", email);

        Long count = query.getSingleResult();
        return count > 0; // false is user does not exist.
    }


    @Override
    public long countAllUserIpAddresses() {
        TypedQuery<Long> query = em.createNamedQuery("UserIpAddressCount", Long.class);
        return query.getSingleResult();
    }

    @Override
    public List<User> list(User user) {
       return em.createQuery("FROM User u").getResultList();
    }

    @Override
    public User find(Long id){
       return em.find(User.class, id);

    }
    @Override
    public long countUsers() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM User u", Long.class);
        return query.getSingleResult();
    }



}




