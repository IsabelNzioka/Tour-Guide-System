package com.systechafrica.database;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Database  implements Serializable {
    private String databaseCreateAt;

    private List<Object> data = new ArrayList<>();

    private static Database dbInstance;

    private Database(){}

    public static Database getDbInstance(){
        if (dbInstance == null) {
            dbInstance = new Database();
            dbInstance.databaseCreateAt = DateFormat.getDateTimeInstance().format(new Date());
            System.out.println("Database created at " + dbInstance.getDatabaseCreateAt());
        }

        return dbInstance;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }


    public List<Object> getData(Class<?> clazz) {

        return data
                .stream()
                .filter(clazz::isInstance)
                .collect(Collectors.toList());

    }

    public String getDatabaseCreateAt() {
        return databaseCreateAt;
    }
//    private List<User> users = new ArrayList<>();
//    private List<Tour> tours = new ArrayList<>();
//    private List<Booking> bookings = new ArrayList<>();
//
//
//
//
//    private static Database dbInstance;
//
////    you cannot create a new instance of this class - call it within the class only
//    private Database() {
//
//    }
//
//    public static Database getDbInstance() {
//        if(dbInstance == null)
//            dbInstance = new Database();
//        return dbInstance;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    public List<Tour> getTours() {
//        return tours;
//    }
//
//
//
//    public void setTours(List<Tour> tours) {
//        this.tours = tours;
//    }
//
//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }
}
