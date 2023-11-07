package com.systechafrica.event;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.TourCategories;
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
        User admin = new User(4l, "IsabelN", "123");
        admin.setRole(UserRole.ADMIN);

        database.getUsers().add(admin);
        database.getUsers().add(new User(0L, "LenaB", "bett"));
        database.getUsers().add(new User(1L, "JohnD", "doe"));
        database.getUsers().add(new User(2L, "annL", "liza"));
        database.getUsers().add(new User(3L, "brianM", "musili"));



        database.getTours().add(new Tour(null, "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 20,  338403,"https://images.unsplash.com/photo-1578894381163-e72c17f2d45f?auto=format&fit=crop&q=60&w=500&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTExfHx0cmF2ZWx8ZW58MHx8MHx8fDA%3D", TourCategories.SAFARI));
        database.getTours().add(new Tour("3023d", "Jungle Tour Adventure", "Pack in the water adventures on this excursion in the Cancun jungle...more", 90, 4566, "https://images.unsplash.com/photo-1516939884455-1445c8652f83?auto=format&fit=crop&q=80&w=1374&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" , TourCategories.CULTURAL));
        database.getTours().add(new Tour(null, "Mayan Heritage History Tour", "Discover Mexico’s rich Maya past with this 5-day heritage tour...more", 100, 7000, "https://images.unsplash.com/photo-1554357475-accb8a88a330?auto=format&fit=crop&q=80&w=1528&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" , TourCategories.SAILING));
        database.getTours().add(new Tour("394h", "Open Water Diver course PADI in Cancun", "While vacationing in Cancun, learn to scuba dive with ...more", 10, 70, "https://images.unsplash.com/photo-1682686581264-c47e25e61d95?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", TourCategories.SAFARI));

    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application has been destroyed");
    }
}
