package com.systechafrica.database;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();
    private List<Tour> tours = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
 



    private static Database dbInstance;

//    you cannot create a new instance of this class - call it within the class only
    private Database() {

    }

    public static Database getDbInstance() {
        if(dbInstance == null)
            dbInstance = new Database();
        return dbInstance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Tour> getTours() {
        return tours;
    }

   

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
