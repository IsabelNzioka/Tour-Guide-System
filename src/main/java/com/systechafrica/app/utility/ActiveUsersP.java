package com.systechafrica.app.utility;

import com.systechafrica.app.model.entity.UserIpAddress;
import com.systechafrica.database.MysqlDatabaseTodelete;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import java.util.HashSet;
import java.util.Set;


@ApplicationScoped
public class ActiveUsersP {


    @Inject
    private MysqlDatabaseTodelete database;

    private Set<String> activeUsersList = new HashSet<>(); //unique  - getIpAdressed from the database

    @Inject
    public ActiveUsersP(MysqlDatabaseTodelete database) {
        this.database = database;
//        activeUsersList.addAll(database.uniqueIpAddresses());
    }


    @Produces
    public int getActiveUsers() {
        return activeUsersList.size();
    }


    public void userIpAddresses(@Observes UserIpAddress address) {
        activeUsersList.add(address.getUserIpAddress());
    }

}
