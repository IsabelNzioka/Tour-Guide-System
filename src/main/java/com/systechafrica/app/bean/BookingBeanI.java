package com.systechafrica.app.bean;

import java.util.List;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;

import javax.ejb.Remote;


@Remote
public interface BookingBeanI extends GenericBeanI<Booking>{
    public void addOrUpdateBooking(Booking booking, Tour tour,String userName);
    public List<Booking> getBookingByUserId(Long userId);

    
}
