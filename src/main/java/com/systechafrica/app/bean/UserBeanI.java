package com.systechafrica.app.bean;


import com.systechafrica.app.model.entity.User;

import javax.ejb.Remote;
import java.sql.SQLException;
import java.util.List;

@Remote
public interface UserBeanI  extends GenericBeanI<User> {
     User register(User user) throws SQLException;
     User changePassword(User user) throws SQLException;
     boolean isUserExists(String email);
     public long countAllUserIpAddresses();

     User find(Long id);


     // List<User> userList();

}
