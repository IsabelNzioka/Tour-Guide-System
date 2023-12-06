package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.UserIpAddress;
import com.systechafrica.database.MysqlDatabaseTodelete;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;

@Singleton
public class ActiveUserBean {

    @EJB
    MysqlDatabaseTodelete database;
    public void userIpAddressLog(@Observes UserIpAddress userIpAddress){
        database.saveOrUpdate(userIpAddress);
    }
}
