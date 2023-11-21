package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.User;

public interface AuthBeanI {
    User authenticate(User loginUser);
    User register(User user);
}
