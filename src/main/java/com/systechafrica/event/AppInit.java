package com.systechafrica.event;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.model.entity.UserRole;
import com.systechafrica.database.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println();
        System.out.println();
        System.out.println("Application has been initialized");

        Database database = Database.getDbInstance();

     //        Add ADMIN
        User admin = new User(4l, "isabel@test.com", "123");
        admin.setRole(UserRole.ADMIN);

        database.getUsers().add(admin);
        database.getUsers().add(new User(0L, "lena@test.com", "bett"));
        database.getUsers().add(new User(1L, "John@test.com", "doe"));
        database.getUsers().add(new User(2L, "ann@test.com", "liza"));
        database.getUsers().add(new User(3L, "brian@test.com", "musili"));

        database.getTours().add(new Tour(null, "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 2000));
        database.getTours().add(new Tour("3023d", "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 9000));
        database.getTours().add(new Tour(null, "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 10000));
        database.getTours().add(new Tour("394h", "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 10000));

    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application has been destroyed");
    }
}
