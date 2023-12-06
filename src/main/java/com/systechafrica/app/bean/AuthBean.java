package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.AuditLog;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.model.entity.UserIpAddress;
import com.systechafrica.database.MysqlDatabaseTodelete;
import com.systechafrica.app.utility.HashText;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class AuthBean extends GenericBean<User>  implements AuthBeanI, Serializable {
//    @EJB
//    MysqlDatabaseTodelete database;
    @PersistenceContext
    EntityManager em;

    @Inject
    private HashText hashText;

    @Inject
    private Event<AuditLog> logger;

    @Inject
    private Event<UserIpAddress> userIpAddressEvent;


    public User authenticate(User loginUser) throws SQLException{

        try {
            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        TypedQuery<User> query = em.createQuery("FROM User u WHERE u.username=:username AND u.password=:password", User.class);
        query.setParameter("username", loginUser.getUsername());
        query.setParameter("password", loginUser.getPassword());

        List<User> users = query.getResultList();

        if (users.isEmpty()) {
            throw new RuntimeException("Invalid user!!");
        }

        User user = users.get(0);

        AuditLog log = new AuditLog();
        log.setLogDetails(user.getUsername() + " logged in at " + DateFormat.getDateTimeInstance().format(new Date()) + ".");

        UserIpAddress userIpAddress = new UserIpAddress();
        userIpAddress.setUserIpAddress("12234");

        em.persist(log);
        em.persist(userIpAddress);

        logger.fire(log);
        userIpAddressEvent.fire(userIpAddress);

        return user;


//        PreparedStatement sqlStmt = database.getConnection().prepareStatement("select id,username from users where username=? and password=? limit 1");
//        sqlStmt.setString(1, loginUser.getUsername());
//        sqlStmt.setString(2, loginUser.getPassword());
//        ResultSet result = sqlStmt.executeQuery();
//
//        User user = null;
//        while (result.next()){
//            user = new User();
//            user.setId(result.getLong("id"));
//            user.setUsername(result.getString("username"));
//
//            AuditLog log = new AuditLog();
//            log.setLogDetails( user.getUsername() + " logged in at " + DateFormat.getDateTimeInstance().format(new Date()) + "." );
//
//            UserIpAddress userIpAddress = new UserIpAddress();
//            userIpAddress.setUserIpAddress("12234");
//
//            logger.fire(log);
//            userIpAddressEvent.fire(userIpAddress);
//
//
//        }
//        return user;
    }

}
