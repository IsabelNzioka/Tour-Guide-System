package com.systechafrica.app.model.entity;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String username;
    private String password;


    private String confirmPassword;
    private UserRole role;

//    email
//    phone number
//    roles - Admin, manager, guides, customers - default role - customers/
//    picture - optional ?

    public  User() {

    }

    public User(long id, String username, String password, String confirmPassword, UserRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = UserRole.CUSTOMER;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
