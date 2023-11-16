package com.systechafrica.app.bean;


import com.systechafrica.app.model.entity.User;

import java.util.List;

public interface UserBeanI {
    User register(User user);

    List<User> list();

    boolean unregister(User user);
}
