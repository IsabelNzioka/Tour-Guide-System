package com.systechafrica.app.bean;

import java.sql.SQLException;

import com.systechafrica.app.model.entity.User;

public interface AuthBeanI {
    User authenticate(User loginUser) throws SQLException;
    User register(User user) throws SQLException;
}
