package com.systechafrica.app.model.entity;

import java.io.Serializable;

import com.systechafrica.app.view.helper.HtmlTable;
import com.systechafrica.app.view.helper.TableColHeader;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;

@DbTable(name = "users")
@HtmlTable(addUrl = "./admin-users?action=add")
public class User extends  BaseEntity {


    @DbTableColumn(name = "username")
    @TableColHeader(headerLabel = "Member Name")
    private String username;

    
    @TableColHeader(headerLabel = "Mobile")
    @DbTableColumn(name = "Mobile")
    private String phonenumber;

    @TableColHeader(headerLabel = "Email")
    @DbTableColumn(name = "Email")
    private String email;

    @DbTableColumn(name = "password")
    private String password;

    private String confirmPassword;

    @DbTableColumn(name = "userRole")
    @TableColHeader(headerLabel = "User Role")
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
