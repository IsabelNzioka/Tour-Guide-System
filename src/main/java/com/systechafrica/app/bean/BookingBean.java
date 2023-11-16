package com.systechafrica.app.bean;

import java.util.List;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.database.Database;

public class BookingBean implements BookingBeanI{

    @Override
    public List<Booking> list() {
     return Database.getDbInstance().getBookings();
    }

  

      @Override
    public Booking addOrUpdateBooking(Booking booking) {
        Database database = Database.getDbInstance();
        database.getBookings().add(booking);
        return booking;
    }

    @Override
    public void deleteBooking(Booking booking) {
    
    }



  
    
}
