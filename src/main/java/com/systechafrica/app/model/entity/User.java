package com.systechafrica.app.model.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.systechafrica.app.view.helper.HtmlTable;
import com.systechafrica.app.view.helper.TableColHeader;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "findUserByUserId", query = "SELECT u FROM User u WHERE u.id = :id")
})
@HtmlTable(addUrl = "./admin-users?action=add",searchUrl = "./admin-users?action=searchUrl",deleteUrl = "./admin-users?action=delete", url="./admin-users")
public class User extends  BaseEntity {


    @Column(name = "username")
    @TableColHeader(headerLabel = "Member Name")
    private String username;



    @Column(name = "Mobile")
    @TableColHeader(headerLabel = "Mobile")
    private String phonenumber;


    @Column(name = "Email")
    @TableColHeader(headerLabel = "Email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "userRole")
    @TableColHeader(headerLabel = "User Role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    
    public  User() {
        this.role = UserRole.CUSTOMER;
        this.role = UserRole.ADMIN;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String string) {
    }
}
