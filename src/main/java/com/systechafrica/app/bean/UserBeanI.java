package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;

public interface UserBeanI {
    User register(User user);

    boolean unregister(User user);
}
