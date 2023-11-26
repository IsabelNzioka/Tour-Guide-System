package com.systechafrica.app.bean;


import com.systechafrica.app.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBeanI  extends GenericBeanI<User> {
     User register(User user) throws SQLException;

    // List<User> list();

    // boolean unregister(User user);
}
