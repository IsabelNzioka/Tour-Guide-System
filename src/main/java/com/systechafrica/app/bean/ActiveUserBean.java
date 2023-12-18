package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.UserIpAddress;
import com.systechafrica.database.MysqlDatabaseTodelete;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class ActiveUserBean {

    @PersistenceContext
    EntityManager em;
    public void userIpAddressLog(@Observes UserIpAddress userIpAddress){
        em.merge(userIpAddress);
    }
}
