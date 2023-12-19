package com.systechafrica.app.model.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.systechafrica.app.view.helper.HtmlTable;
import com.systechafrica.app.view.helper.TableColHeader;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "findUserByUserId", query = "SELECT u FROM User u WHERE u.id = :id")
})
@DynamicInsert
@DynamicUpdate
@HtmlTable(addUrl = "./admin-users?action=add",editUrl = "./admin-update-user?action=update",deleteUrl = "./admin-users?action=delete", url="./admin-users")
public class User extends  BaseEntity {


    @NotNull
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
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "userRole")
    @TableColHeader(headerLabel = "User Role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Booking> bookings;

    @JsonIgnore
    public List<Booking> getBookings() {
        return bookings;
    }
    
    public  User() {
        this.role = UserRole.USER;
//        this.role = UserRole.ADMIN;
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
