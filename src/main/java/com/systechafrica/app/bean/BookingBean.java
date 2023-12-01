package com.systechafrica.app.bean;

import java.util.Date;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.utility.BookingNoGenerator;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookingBean extends GenericBean<Booking> implements BookingBeanI{

    @Inject
    private BookingNoGenerator bookingNoGenerator;

    @Override
    public void addOrUpdateEntity(Booking booking) {
        if(booking.getCreatedAt() == null)
            booking.setCreatedAt(new Date());

        booking.setBookingNo(bookingNoGenerator.generate());
        getDao().addOrUpdateEntity(booking);
    }
    
}
