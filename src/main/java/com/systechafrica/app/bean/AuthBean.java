package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.AuditLog;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.model.entity.UserIpAddress;
import com.systechafrica.app.utility.HashText;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

@Stateless
public class AuthBean extends GenericBean<User>  implements AuthBeanI, Serializable {

    @PersistenceContext
    EntityManager em;

    @Inject
    private HashText hashText;

    @Inject
    private Event<AuditLog> logger;

    @Inject
    private Event<UserIpAddress> userIpAddressEvent;


    public User authenticate(User loginUser){
        System.out.println("loginUser = " + loginUser);

        try {
            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        TypedQuery<User> query = em.createQuery("FROM User u WHERE u.username=:username AND u.password=:password", User.class);
        query.setParameter("username", loginUser.getUsername());
        query.setParameter("password", loginUser.getPassword());

        User user = query.getSingleResult();

        if (user==null) {
            throw new RuntimeException("Invalid user!!");
        }


        AuditLog log = new AuditLog();
        log.setLogDetails(user.getUsername() + " logged in at " + DateFormat.getDateTimeInstance().format(new Date()) + ".");

        try {
            UserIpAddress userIpAddress = new UserIpAddress();
            String ipAddress = getPublicIPAddress();
            userIpAddress.setUserIpAddress(ipAddress);
            em.persist(userIpAddress);
            userIpAddressEvent.fire(userIpAddress);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        em.persist(log);
        logger.fire(log);

        return user;

    }

    public String getPublicIPAddress() throws IOException {
        String url = "https://httpbin.org/ip";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }

}
