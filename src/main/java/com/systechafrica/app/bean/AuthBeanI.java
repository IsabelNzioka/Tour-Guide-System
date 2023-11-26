package com.systechafrica.app.bean;

import java.sql.SQLException;

import com.systechafrica.app.model.entity.User;

import javax.ejb.Remote;

@Remote
public interface AuthBeanI {
    User authenticate(User loginUser) throws SQLException;
}
