package com.systechafrica.event;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.MysqlDatabase;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application initialization started.");
        MysqlDatabase.updateSchema();
        System.out.println("Application initialization completed.");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application has been destroyed");
        try {
            MysqlDatabase database = MysqlDatabase.getInstance();

            if (database.getConnection() != null){
                System.out.println("Connection closed.");
                database.getConnection().close();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
